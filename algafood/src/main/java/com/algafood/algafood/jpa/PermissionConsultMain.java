package com.algafood.algafood.jpa;

import com.algafood.algafood.AlgafoodApplication;
import com.algafood.algafood.domain.model.Kitchen;
import com.algafood.algafood.domain.model.Permission;
import com.algafood.algafood.domain.repository.KitchenRepository;
import com.algafood.algafood.domain.repository.PermissionRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class PermissionConsultMain {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);
        PermissionRepository permissionRepository = applicationContext.getBean(PermissionRepository.class);

        //LIST ALL

        List<Permission> permissions = permissionRepository.listAll();
        for (Permission permission : permissions){
            System.out.printf("%s - %s\n", permission.getName(), permission.getDescription());
        }

        //REPLACE A PERMISSION

//        Permission permission = new Permission();
//        permission.setId(1L);
//        permission.setName("Montes");
//        permission.setDescription("super admin permission");
//        permissionRepository.save(permission);

        //FIND BY ID

//        Permission permission = permissionRepository.findById(3L);
//        System.out.println(permission.getName());


        //REMOVE A PERMISSION BASED ON AN ID

//        Permission permission = new Permission();
//        permission.setId(1L);
//        permissionRepository.remove(permission);

        //SET A NEW PERMISSION

//        Permission permission1 = new Permission();
//        permission1.setName("marco");
//        permission1.setDescription("pode");
//        Permission permission2 = new Permission();
//        permission2.setName("user");
//        permission2.setDescription("user permission");
//
//        permission1 = permissionRepository.save(permission1);
//        permission2 = permissionRepository.save(permission2);
//
//        System.out.printf("%s - %s\n", permission1.getName(), permission1.getDescription());
//        System.out.printf("%s - %s\n", permission2.getName(), permission2.getDescription());

    }
}
