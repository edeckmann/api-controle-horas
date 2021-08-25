package eng.elemar.ponto.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

    @Autowired
    private ModelMapper mapper;


    public <S, D> D mapTo(S source, Class<D> destClass) {
        return mapper.map(source, destClass);
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
          .stream()
          .map(element -> mapper.map(element, targetClass))
          .collect(Collectors.toList());
    }
}
