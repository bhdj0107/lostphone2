package lostphone.infra;

import lostphone.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeviceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Device>> {

    @Override
    public EntityModel<Device> process(EntityModel<Device> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/changedeviceinfo"
                )
                .withRel("changedeviceinfo")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/changedevicelocation"
                )
                .withRel("changedevicelocation")
        );

        return model;
    }
}
