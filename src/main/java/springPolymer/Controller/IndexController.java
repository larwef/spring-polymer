package springPolymer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @RequestMapping(value = "/*", method = RequestMethod.GET)
    public String index(
            @RequestParam(value="query", required=false, defaultValue="default") String query,
            Model model){
        model.addAttribute("query", query);
        return "index";
    }

    @RequestMapping(value = "/{path}", method = RequestMethod.GET)
    public String indexWithPath(
            @PathVariable(value="path") String path,
            @RequestParam(value="query", required=false, defaultValue="default") String query,
            Model model){
        model.addAttribute("query", query);
        model.addAttribute("path", path);
        return "index";
    }
}
