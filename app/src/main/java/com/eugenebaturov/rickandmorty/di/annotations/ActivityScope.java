package com.eugenebaturov.rickandmorty.di.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface ActivityScope {
}
