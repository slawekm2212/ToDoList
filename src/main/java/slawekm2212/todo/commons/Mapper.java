package slawekm2212.todo.commons;

public interface Mapper<F, T> {

    T map(F from);

    F revers(T to);

}
