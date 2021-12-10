package am.gbr.web.controller;

import am.gbr.common.entity.ListingStatus;
import am.gbr.common.service.ListingCategoryService;
import am.gbr.common.service.ListingGroupService;
import am.gbr.common.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    private final ListingService listingService;
    private final ListingGroupService listingGroupService;
    private final ListingCategoryService listingCategoryService;

    @GetMapping
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("listingGroups", listingGroupService.findAll());
        modelMap.addAttribute("topListings", listingService.findAllByListingStatus(ListingStatus.TOP));
        modelMap.addAttribute("listingCategories", listingCategoryService.findAll());
        return "index";
    }

}
