package lostphone.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import lostphone.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/losts")
@Transactional
public class LostController {

    @Autowired
    LostRepository lostRepository;

    @RequestMapping(
        value = "/losts/{id}/changelostcontact",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Lost changeLostContact(
        @PathVariable(value = "id") Long id,
        @RequestBody ChangeLostContactCommand changeLostContactCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lost/changeLostContact  called #####");
        Optional<Lost> optionalLost = lostRepository.findById(id);

        optionalLost.orElseThrow(() -> new Exception("No Entity Found"));
        Lost lost = optionalLost.get();
        lost.changeLostContact(changeLostContactCommand);

        lostRepository.save(lost);
        return lost;
    }

    @RequestMapping(
        value = "/losts/{id}/changelostinfo",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Lost changeLostInfo(
        @PathVariable(value = "id") Long id,
        @RequestBody ChangeLostInfoCommand changeLostInfoCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /lost/changeLostInfo  called #####");
        Optional<Lost> optionalLost = lostRepository.findById(id);

        optionalLost.orElseThrow(() -> new Exception("No Entity Found"));
        Lost lost = optionalLost.get();
        lost.changeLostInfo(changeLostInfoCommand);

        lostRepository.save(lost);
        return lost;
    }

    @RequestMapping(
        value = "/losts/sendlostdeviceinitializerequest",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Lost sendLostDeviceInitializeRequest(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SendLostDeviceInitializeRequestCommand sendLostDeviceInitializeRequestCommand
    ) throws Exception {
        System.out.println(
            "##### /lost/sendLostDeviceInitializeRequest  called #####"
        );
        Lost lost = new Lost();
        lost.sendLostDeviceInitializeRequest(
            sendLostDeviceInitializeRequestCommand
        );
        lostRepository.save(lost);
        return lost;
    }

    @RequestMapping(
        value = "/losts/sendlostdevicebackuprequest",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Lost sendLostDeviceBackupRequest(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SendLostDeviceBackupRequestCommand sendLostDeviceBackupRequestCommand
    ) throws Exception {
        System.out.println(
            "##### /lost/sendLostDeviceBackupRequest  called #####"
        );
        Lost lost = new Lost();
        lost.sendLostDeviceBackupRequest(sendLostDeviceBackupRequestCommand);
        lostRepository.save(lost);
        return lost;
    }

    @RequestMapping(
        value = "/losts/reportlostdeviceacquired",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Lost reportLostDeviceAcquired(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReportLostDeviceAcquiredCommand reportLostDeviceAcquiredCommand
    ) throws Exception {
        System.out.println(
            "##### /lost/reportLostDeviceAcquired  called #####"
        );
        Lost lost = new Lost();
        lost.reportLostDeviceAcquired(reportLostDeviceAcquiredCommand);
        lostRepository.save(lost);
        return lost;
    }
}
//>>> Clean Arch / Inbound Adaptor
