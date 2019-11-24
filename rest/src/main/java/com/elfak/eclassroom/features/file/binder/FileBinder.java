package com.elfak.eclassroom.features.file.binder;

import com.elfak.eclassroom.service.file.FileUploadService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class FileBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindAsContract(FileUploadService.class);
    }
}
