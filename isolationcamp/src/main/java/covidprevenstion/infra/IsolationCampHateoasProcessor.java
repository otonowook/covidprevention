package covidprevenstion.infra;

import covidprevenstion.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class IsolationCampHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<IsolationCamp>> {

    @Override
    public EntityModel<IsolationCamp> process(
        EntityModel<IsolationCamp> model
    ) {
        return model;
    }
}
