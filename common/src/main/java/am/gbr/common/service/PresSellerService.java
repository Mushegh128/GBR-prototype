package am.gbr.common.service;

import am.gbr.common.exception.PreSellerNotFoundException;
import am.gbr.common.request.PresSellerRequest;
import am.gbr.common.response.PresSellerResponse;

import java.util.List;

public interface PresSellerService {

    List<PresSellerResponse> findAll();

    void update(PresSellerRequest presSellerRequest) throws PreSellerNotFoundException;

    void save(PresSellerRequest presSellerRequest);

    PresSellerResponse findByEmail(String email);

    PresSellerResponse findByName(String name);

    PresSellerResponse findByPhoneNumber(String phoneNumber);

    PresSellerResponse findById(Long id);
}
