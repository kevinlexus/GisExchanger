package com.ric.st.builder.impl;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ric.bill.model.bs.Lst;
import com.ric.bill.model.exs.Task;
import com.ric.bill.model.exs.TaskPar;
import com.ric.bill.model.exs.TaskToTask;
import com.ric.st.builder.TaskBuilders;

import lombok.extern.slf4j.Slf4j;

/**
 * Сервисы обслуживания задач
 * @author lev
 *
 */
@Slf4j
@Service
public class TaskBuilder implements TaskBuilders {

    @PersistenceContext
    private EntityManager em;
    // хранилище старых и новых ID
	private HashMap<Task, Task> mapTask;

    /**
     * Активация повторяемого задания
     * @param - task - задание
     */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void activateRptTask(Task task) {
		
		mapTask = new HashMap<Task, Task>();
		// найти все связи с дочерними записями, в заданиях которых нет родителя (главные),
		// по определённому типу
		task.getInside().stream().forEach(t-> {
			log.info("Check id={}, chld={}", t.getId(), t.getChild());
		});

		task.getInside().stream()
			.filter(t-> t.getTp().getCd().equals("Связь повторяемого задания"))
		    .filter(t-> t.getChild().getParent() == null).forEach(t-> {
			// Скопировать задание
			log.info("Задание id={}", t.getChild().getId());
			copyTask(t.getChild(), null, 0);
			copyTask(t.getChild(), null, 1);
		}) ;
		
	}

	/**
	 * Создать дочерние задания
	 * @param src - задание - шаблон
	 * @param parent - родительское задание
	 * @param tp - тип выполнения, 0 - скопировать задания, параметры, 1 - скопировать связи
	 */
	private void copyTask(Task src, Task parent, int tp) {
		Task foundElem = null;
		if (tp==0) {
			// скопировать задание
			foundElem = em.find(Task.class, src.getId());
			em.detach(foundElem);
			foundElem.setId(null);
			// указать нового родителя
			foundElem.setParent(parent);
			// почистить коллекции
			foundElem.setAppTp(7);
			foundElem.setChild(null);
			foundElem.setInside(null);
			foundElem.setOutside(null);
			foundElem.setTaskPar(null);
			// сохранить
			em.persist(foundElem);
			// копировать параметры
			copyTaskPar(src, foundElem);
			// сохранить соответствие старого задания - новому
			mapTask.put(src, foundElem);
		} else {
			// скопировать связи
			copyTaskLink(src);
		}

		// Найти все дочерние задания, обработать их
		for (Task t :src.getChild()) {
			// рекурсивно вызвать себя же
			copyTask(t, foundElem, tp);
		};
		
	}

	/**
	 * Копировать параметры задания
	 * @param src - источник
	 * @param dst - назначение
	 */
    private void copyTaskPar(Task src, Task dst) {
    	src.getTaskPar().stream().forEach(t-> {
        	TaskPar foundElem = em.find(TaskPar.class, t.getId());
        	em.detach(foundElem);
        	foundElem.setId(null);
        	foundElem.setTask(dst);
        	em.persist(foundElem);
    	});
    }
    
	/**
	 * Копировать дочерние связи задания
	 * @param src - источник
	 */
    private void copyTaskLink(Task src) {
    	log.info(" id={}, size1={}, size2={}", src.getId(), src.getInside().size(), src.getOutside().size());
    	src.getInside().stream().forEach(t-> {
    		TaskToTask foundElem = em.find(TaskToTask.class, t.getId());
        	em.detach(foundElem);
        	foundElem.setId(null);
    		// получить новый элемент по старому
    		Task parent = mapTask.get(src);
        	foundElem.setParent(parent);
        	log.info(" check parent.id={}, parent={}", src.getId(), parent);
    		// получить новый элемент по старому
    		Task chld = mapTask.get(t.getChild());
        	log.info(" check chld.id={}, chld={}", t.getChild().getId(), chld);

    		log.info("Таблица соответствий:");
    		mapTask.entrySet().stream().forEach(d-> {
    			log.info("Старый Id={}, новый Id={}", d.getKey().getId(), d.getValue().getId());
    		});
    		
        	
    		if (chld == null) {
    			log.info("Элемент не найден, возможно относится к другой иерархии Task id={}", t.getChild().getId());
        		foundElem.setChild(t.getChild());
    		} else {
        		foundElem.setChild(chld);
    		}
    		if (parent != null) {
        		log.info("parent: копировать с id={} на id={}", src.getId(), parent.getId());
    		} else {
        		log.info("parent: копировать с id={} на null", src.getId());
    		}
    		
    		if (chld != null) {
        		log.info("child: копировать с id={} на id={}", t.getChild().getId(), chld.getId());
    		} else {
        		log.info("child: копировать с id={} на null", t.getChild().getId());
    		}
    		
    		em.persist(foundElem);
    	});
    	
    }
    
}