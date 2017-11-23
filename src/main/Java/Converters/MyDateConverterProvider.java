package Converters;

import POJO.MyDate;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

@Provider
public class MyDateConverterProvider implements ParamConverterProvider {
    public <T> ParamConverter<T> getConverter(final Class<T> aClass, Type type, Annotation[] annotations) {
        if (aClass.getName().equalsIgnoreCase(MyDate.class.getName())) {
            //return the right converter
            return new ParamConverter<T>() {
                public T fromString(String s) {
                    Calendar requestDate = Calendar.getInstance();
                    if ("tommorrow".equalsIgnoreCase(s)) {
                        requestDate.add(Calendar.DATE, 1);
                    } else if ("yesterday".equalsIgnoreCase(s)) {
                        requestDate.add(Calendar.DATE, -1);
                    }
                    MyDate myDate = new MyDate();
                    myDate.setDate(requestDate.get(Calendar.DATE));
                    myDate.setMonth(requestDate.get(Calendar.MONTH));
                    myDate.setYear(requestDate.get(Calendar.YEAR));
                    return aClass.cast(myDate);
                }

                public String toString(T t) {
                    if (t == null) {
                        return null;
                    }
                    return t.toString();
                }
            };
        }
        return null;
    }
}
