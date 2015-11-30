package io.uengine.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Properties;

@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * SLF4J Logging
     */
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    @Qualifier("config")
    private Properties config;


    /**
     * 인덱스 페이지로 이동한다.
     *
     * @return Model And View
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session, final Locale locale) {
        session.setAttribute("lang", locale.toString());

        return new ModelAndView("index");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(HttpSession session, final Locale locale) {
        session.setAttribute("lang", locale.toString());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public ModelAndView about(HttpSession session) {
        return new ModelAndView("about");
    }

    @RequestMapping(value = "product/flamingo", method = RequestMethod.GET)
    public ModelAndView flamingo(HttpSession session) {
        return new ModelAndView("flamingo/flamingo");
    }

    @RequestMapping(value = "product/flamingo/features", method = RequestMethod.GET)
    public ModelAndView flamingoFeatures(HttpSession session, @RequestParam(defaultValue = "") String tip) {
        if (!tip.isEmpty()) {
            ModelAndView index = new ModelAndView("flamingo/features/" + tip);
            return index;
        } else {
            ModelAndView index = new ModelAndView("flamingo/features");
            return index;
        }
    }

    @RequestMapping(value = "services", method = RequestMethod.GET)
    public ModelAndView services(HttpSession session) {
        return new ModelAndView("services");
    }

    @RequestMapping(value = "support", method = RequestMethod.GET)
    public ModelAndView support(HttpSession session) {
        return new ModelAndView("support");
    }


    @RequestMapping(value = "download", method = RequestMethod.GET)
    public ModelAndView download(HttpSession session) {
        ModelAndView index = new ModelAndView("download");
        return index;
    }

    @RequestMapping(value = "manual", method = RequestMethod.GET)
    public ModelAndView manual(HttpSession session, @RequestParam(defaultValue = "") String product) {
        ModelAndView index = new ModelAndView();
        if (product.equals("flamingo")) {
            index.setViewName("flamingo/flamingo_manual");
        }
        return index;
    }


    @RequestMapping(value = "redirect", method = RequestMethod.GET)
    public ModelAndView redirect(@RequestParam String url) {
        return new ModelAndView("redirect:" + url);
    }

    @RequestMapping(value = "go", method = RequestMethod.GET)
    public ModelAndView go(@RequestParam String url) {
        return new ModelAndView(url);
    }

    @RequestMapping(value = "/pricing/flamingo2", method = RequestMethod.GET)
    public ModelAndView pricing(HttpSession session) {
        ModelAndView mav = new ModelAndView("/shop/pricing");
        mav.addObject("productName", "Flamingo2");
        mav.addObject("family", "SUBSCRIPTION");
        mav.addObject("license", "SUBSCRIPTION");
        mav.addObject("version", "2.0.0");
        return mav;
    }
}
