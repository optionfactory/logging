package net.optionfactory.logging;

import org.apache.log4j.Priority;

public class Logger {

    private final org.apache.log4j.Logger inner;

    public static Logger getLogger(Class clazz) {
        return new Logger(clazz);
    }

    public Logger(org.apache.log4j.Logger inner) {
        this.inner = inner;
    }

    public Logger(Class clazz) {
        this(org.apache.log4j.Logger.getLogger(clazz));
    }

    public void info(String message, Object... arguments) {
        inner.info(String.format(message, arguments));
    }

    public void info(Throwable t, String message, Object... arguments) {
        inner.info(String.format(message, arguments), t);
    }

    public void debug(String message, Object... arguments) {
        inner.debug(String.format(message, arguments));
    }

    public void debug(Throwable t, String message, Object... arguments) {
        inner.debug(String.format(message, arguments), t);
    }

    public void error(String message, Object... arguments) {
        inner.error(String.format(message, arguments));
    }

    public void error(Throwable t, String message, Object... arguments) {
        inner.error(String.format(message, arguments), t);
    }

    public void trace(String message, Object... arguments) {
        inner.trace(String.format(message, arguments));
    }

    public void trace(Throwable t, String message, Object... arguments) {
        inner.trace(String.format(message, arguments), t);
    }

    public void fatal(String message, Object... arguments) {
        inner.fatal(String.format(message, arguments));
    }

    public void fatal(Throwable t, String message, Object... arguments) {
        inner.fatal(String.format(message, arguments), t);
    }

    public void log(Priority priority, String message, Object... arguments) {
        inner.log(priority, String.format(message, arguments));
    }

    public void log(Throwable t, Priority priority, String message, Object... arguments) {
        inner.log(priority, String.format(message, arguments), t);
    }

    public org.apache.log4j.Logger getInner() {
        return inner;
    }

}
