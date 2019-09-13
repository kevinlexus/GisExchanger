package com.ric.signature.sign.args;

import com.beust.jcommander.Parameter;
import com.ric.signature.sign.commands.SignCommand;

/**
 * Параметры командной строки, общие для всех команд.
 */
public class AbstractParameters {
    @Parameter(names = {"-h", "-help"}, help = true)
    private boolean help;

    public boolean isHelp() {
        return help;
    }

    public SignCommand createCommand() {
        return null;
    }
}
