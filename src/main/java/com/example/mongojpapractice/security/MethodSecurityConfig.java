//package com.example.mongojpapractice.security;
//
//import com.example.mongojpapractice.security.core.CustomMethodSecurityExpressionHandler;
//import com.example.mongojpapractice.security.core.CustomPermissionEvaluator;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
//
//    @Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        CustomMethodSecurityExpressionHandler expressionHandler =
//            new CustomMethodSecurityExpressionHandler();
//        expressionHandler.setPermissionEvaluator(new CustomPermissionEvaluator());
//        return expressionHandler;
//    }
//}
