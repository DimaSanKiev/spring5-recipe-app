package guru.springframework.recipe.converter;

import guru.springframework.recipe.command.UnitOfMeasureCommand;
import guru.springframework.recipe.model.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand uomc) {
        if (uomc == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uomc.getId());
        uom.setDescription(uomc.getDescription());
        return uom;
    }
}
