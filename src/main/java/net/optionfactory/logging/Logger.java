package net.optionfactory.logging;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.spi.LocationAwareLogger;

public class Logger {

    private final LocationAwareLogger inner;
    private static final String LOGGER_FQCN = Logger.class.getName();
    private static final Marker NO_MARKER = null;
    private static final Throwable NO_THROWABLE = null;
    private static final Object[] NO_PARAMS = null;

    private Logger(Class clazz) {
        this.inner = (LocationAwareLogger) LoggerFactory.getLogger(clazz);
    }

    public static Logger getLogger() {
        try {
            throw new RuntimeException();
        } catch (RuntimeException expected) {
            try {
                final StackTraceElement[] stackTrace = expected.getStackTrace();
                final Class clazz = Class.forName(stackTrace[1].getClassName());
                return new Logger(clazz);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void trace(String template, Object... params) {
        if (inner.isTraceEnabled()) {
            if (params.length > 0 && (params[params.length - 1] instanceof Throwable)) {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.TRACE_INT, String.format(template, params), NO_PARAMS, (Throwable) params[params.length - 1]);
            } else {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.TRACE_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
            }
        }
    }

    public void trace(String template, Supplier... suppliers) {
        if (inner.isTraceEnabled()) {
            final Object[] params = Stream.of(suppliers).map(s -> s.get()).toArray();
            inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.TRACE_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
        }
    }

    public void debug(String template, Object... params) {
        if (inner.isDebugEnabled()) {
            if (params.length > 0 && (params[params.length - 1] instanceof Throwable)) {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.DEBUG_INT, String.format(template, params), NO_PARAMS, (Throwable) params[params.length - 1]);
            } else {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.DEBUG_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
            }
        }
    }

    public void debug(String template, Supplier... suppliers) {
        if (inner.isDebugEnabled()) {
            final Object[] params = Stream.of(suppliers).map(s -> s.get()).toArray();
            inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.DEBUG_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
        }
    }

    public void info(String template, Object... params) {
        if (inner.isInfoEnabled()) {
            if (params.length > 0 && (params[params.length - 1] instanceof Throwable)) {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.INFO_INT, String.format(template, params), NO_PARAMS, (Throwable) params[params.length - 1]);
            } else {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.INFO_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
            }
        }
    }

    public void info(String template, Supplier... suppliers) {
        if (inner.isInfoEnabled()) {
            final Object[] params = Stream.of(suppliers).map(s -> s.get()).toArray();
            inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.INFO_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
        }
    }

    public void warn(String template, Object... params) {
        if (inner.isWarnEnabled()) {
            if (params.length > 0 && (params[params.length - 1] instanceof Throwable)) {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.WARN_INT, String.format(template, params), NO_PARAMS, (Throwable) params[params.length - 1]);
            } else {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.WARN_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
            }
        }
    }

    public void warn(String template, Supplier... suppliers) {
        if (inner.isWarnEnabled()) {
            final Object[] params = Stream.of(suppliers).map(s -> s.get()).toArray();
            inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.WARN_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
        }
    }

    public void error(String template, Object... params) {
        if (inner.isErrorEnabled()) {
            if (params.length > 0 && (params[params.length - 1] instanceof Throwable)) {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.ERROR_INT, String.format(template, params), NO_PARAMS, (Throwable) params[params.length - 1]);
            } else {
                inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.ERROR_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
            }
        }
    }

    public void error(String template, Supplier... suppliers) {
        if (inner.isErrorEnabled()) {
            final Object[] params = Stream.of(suppliers).map(s -> s.get()).toArray();
            inner.log(NO_MARKER, LOGGER_FQCN, LocationAwareLogger.ERROR_INT, String.format(template, params), NO_PARAMS, NO_THROWABLE);
        }
    }

}
