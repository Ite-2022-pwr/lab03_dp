package pl.pwr.ite.server.web.mapper;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

public interface Mapper<S, D> {

    D map(S source);

    void map(S source, D destination);

    <Sx, Dx> void map(Consumer<Dx> consumer, Sx source, Mapper<Sx, Dx> mapper);

    <Sx, Dx> void map(Consumer<Dx[]> consumer, Iterable<Sx> source, Mapper<Sx, Dx> mapper);

    List<D> map(Iterable<? extends S> source);

    void transform(S source, D destination);

    D createDestination(S source);

    Class<D> getDestinationType();
}
