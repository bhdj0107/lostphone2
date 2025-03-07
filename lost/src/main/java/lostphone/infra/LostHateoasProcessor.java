package lostphone.infra;

import lostphone.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class LostHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Lost>> {

    @Override
    public EntityModel<Lost> process(EntityModel<Lost> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/changelostcontact"
                )
                .withRel("changelostcontact")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/changelostinfo")
                .withRel("changelostinfo")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/sendlostdeviceinitializerequest"
                )
                .withRel("sendlostdeviceinitializerequest")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/sendlostdevicebackuprequest"
                )
                .withRel("sendlostdevicebackuprequest")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/reportlostdeviceacquired"
                )
                .withRel("reportlostdeviceacquired")
        );

        return model;
    }
}
