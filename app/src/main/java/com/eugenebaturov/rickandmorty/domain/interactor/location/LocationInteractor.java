package com.eugenebaturov.rickandmorty.domain.interactor.location;

import com.eugenebaturov.rickandmorty.data.entity.LocationRequest;

import java.io.IOException;
import java.util.List;

public interface LocationInteractor {

    List<LocationRequest> getAllLocationFromRepository() throws IOException;

    LocationRequest getLocationByIdFromRepository(int locationId) throws IOException;
}
