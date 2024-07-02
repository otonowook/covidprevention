package covidprevenstion.infra;

import covidprevenstion.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ReserveHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Reserve>> {

    @Override
    public EntityModel<Reserve> process(EntityModel<Reserve> model) {
        return model;
    }
}
