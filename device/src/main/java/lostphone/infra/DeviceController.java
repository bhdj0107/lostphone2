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
// @RequestMapping(value="/devices")
@Transactional
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(
        value = "/devices/{id}/changedeviceinfo",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Device changeDeviceInfo(
        @PathVariable(value = "id") Long id,
        @RequestBody ChangeDeviceInfoCommand changeDeviceInfoCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /device/changeDeviceInfo  called #####");
        Optional<Device> optionalDevice = deviceRepository.findById(id);

        optionalDevice.orElseThrow(() -> new Exception("No Entity Found"));
        Device device = optionalDevice.get();
        device.changeDeviceInfo(changeDeviceInfoCommand);

        deviceRepository.save(device);
        return device;
    }

    @RequestMapping(
        value = "/devices/{id}/changedevicelocation",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Device changeDeviceLocation(
        @PathVariable(value = "id") Long id,
        @RequestBody ChangeDeviceLocationCommand changeDeviceLocationCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /device/changeDeviceLocation  called #####");
        Optional<Device> optionalDevice = deviceRepository.findById(id);

        optionalDevice.orElseThrow(() -> new Exception("No Entity Found"));
        Device device = optionalDevice.get();
        device.changeDeviceLocation(changeDeviceLocationCommand);

        deviceRepository.save(device);
        return device;
    }
}
//>>> Clean Arch / Inbound Adaptor
