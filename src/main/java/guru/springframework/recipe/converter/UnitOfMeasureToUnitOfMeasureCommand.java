package guru.springframework.recipe.converter;

import guru.springframework.recipe.command.UnitOfMeasureCommand;
import guru.springframework.recipe.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure uom) {
        if (uom != null) {
            final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
            uomc.setId(uom.getId());
            uomc.setDescription(uom.getDescription());
            return uomc;
        }
        return null;
    }
}
