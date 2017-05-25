package springPolymer.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class ResourceController {

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public Map<String, Object> resourceWithQuery(
            @RequestParam(value="query", required=false, defaultValue="default") String query){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("query", query);
        return model;
    }

    @RequestMapping(value = "/resource/{path}", method = RequestMethod.GET)
    public Map<String, Object> resourceWithPathAndQuery(
            @PathVariable(value="path") String path,
            @RequestParam(value="query", required=false, defaultValue="default") String query){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("path", path);
        model.put("query", query);
        return model;
    }
}
