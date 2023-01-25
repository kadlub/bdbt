package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class AppController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/user").setViewName("user/user");
        registry.addViewController("/user_edycja").setViewName("/user/user_edycja");
        registry.addViewController("/user/user_edycja_form").setViewName("/user/user_edycja_form");
    }

    @Controller
    public class DashboardController {

        @RequestMapping("/user/user_edycja")
        public String showKlienciPage(HttpServletRequest request, @AuthenticationPrincipal User user, Model model) {
                List<Klienci> klientList = daoKlient.list();
                model.addAttribute("klientList", klientList);
                return "/user/user_edycja";

        }

        @RequestMapping(value = "/klienci/new")
        public String showNewKlientForm(Model model) {
            Klienci newKlient = new Klienci();

            model.addAttribute("newKlienci", newKlient);

            return "user/user_new_form";
        }

        @RequestMapping(value = "/klienci/save", method = RequestMethod.POST)
        public String saveKlienci(@ModelAttribute("newKlient") Klienci newKlient) {
            daoKlient.save(newKlient);

            return "redirect:/user/user_edycja";
        }

        @RequestMapping(value = "/klienci/edit/{id}")
        public ModelAndView showEditKlienciForm(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("user/user_edycja_form");
            List<Klienci> positionList = daoKlient.list();
            Klienci newKlienci = daoKlient.get(id);

            mav.addObject("klient", newKlienci);

            return mav;
        }

        @RequestMapping(value = "/klienci/update", method = RequestMethod.POST)
        public String updateKlienci(@ModelAttribute("newKlienci") Klienci newKlienci) {
            daoKlient.update(newKlienci);

            return "redirect:/user/user_edycja";
        }

        @RequestMapping(value = "/klienci/delete/{id}")
        public String deleteEmployee(@PathVariable(name = "id") int id) {
            daoKlient.delete(id);

            return "redirect:/user/user_edycja";
        }

        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/user";
            } else {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value = {"/user"})
    public String showUserPage(Model model) {
        return "user/user";
    }

    @Autowired
    private OddzialyDAO dao;

    @RequestMapping("/")
    public String vievHomePage(Model model) {
        List<Oddzialy> listOddzialy = dao.list();
        model.addAttribute("listOddzialy", listOddzialy);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Oddzialy oddzial = new Oddzialy();
        model.addAttribute("Oddzial", oddzial);

        return "new_form";
    }

    @Autowired
    private KlienciDAO daoKlient;

    @RequestMapping("/")
    public String viewKlient(Model model) {
        List<Klienci> listKlienci = daoKlient.list();
        model.addAttribute("listKlienci", listKlienci);
        return "index";
    }

    @RequestMapping("/new")
    public String showKlient(Model model) {
        Klienci klient = new Klienci();
        model.addAttribute("Klient", klient);

        return "new_form";
    }

}
