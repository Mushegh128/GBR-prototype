package am.gbr.common.mapper;

import am.gbr.common.entity.PresSeller;
import am.gbr.common.mapper.config.BaseMapper;
import am.gbr.common.request.PresSellerRequest;
import am.gbr.common.response.PresSellerResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PresSellerMapper implements BaseMapper<PresSeller, PresSellerRequest, PresSellerResponse> {

    private final ModelMapper mapper;

    @Override
    public PresSeller toEntity(PresSellerRequest presSellerRequest) {
        return mapper.map(presSellerRequest, PresSeller.class);
    }

    @Override
    public PresSellerResponse toResponse(PresSeller presSeller) {
        return mapper.map(presSeller, PresSellerResponse.class);
    }
}
