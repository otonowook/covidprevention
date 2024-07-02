package covidprevenstion.infra;

import covidprevenstion.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Test>> {

    @Override
    public EntityModel<Test> process(EntityModel<Test> model) {
        return model;
    }
}
