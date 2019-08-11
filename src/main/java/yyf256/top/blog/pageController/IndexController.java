package yyf256.top.blog.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yyf256.top.blog.bean.TechnicalSearch;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.service.BookService;
import yyf256.top.blog.service.DiaryService;
import yyf256.top.blog.service.TechShareService;
import yyf256.top.blog.service.UserService;
import yyf256.top.blog.util.PageSearch;
import yyf256.top.blog.util.StringUtil;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    TechShareService techShareService;

    @Autowired
    DiaryService diaryService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mov = new ModelAndView();
        addLeft(mov);
        addRight(mov);
        mov.addObject("announcement",userService.getConfigValue("Announcement").get(ResponseConfig.RSP_CONTENT));
        mov.addObject("faceImgs",userService.getFaceImgs().get("faceImgs"));
        mov.setViewName("index");
        return mov;
    }

    /**
     * 添加左侧数据
     * @param mov
     */
    private void addLeft(ModelAndView mov){
        mov.addObject("photoAndTips",userService.getPhotoAndTips().get(ResponseConfig.RSP_CONTENT));
        mov.addObject("books",bookService.getNearlyBooks(5).get(ResponseConfig.RSP_CONTENT));
    }

    /**
     * 添加右侧数据
     * @param mov
     */
    private void addRight(ModelAndView mov){
        mov.addObject("connectInfos", userService.getConnectInfo().get(ResponseConfig.RSP_CONTENT));
        mov.addObject("moods",userService.getNearlyMoods(3).get(ResponseConfig.RSP_CONTENT));
    }

    @RequestMapping("/shareTechnical")
    public ModelAndView shareTechnical(String type,String pageIndex,String pagelimit){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("techTypes",techShareService.getTechTypes().get(ResponseConfig.RSP_CONTENT));
        mov.addObject("nowType",type);
        TechnicalSearch technicalSearch = new TechnicalSearch();
        if(!StringUtil.isEmpty(pageIndex)){
            technicalSearch.setCur(Integer.parseInt(pageIndex));
        }
        if(!StringUtil.isEmpty(pagelimit)){
            technicalSearch.setSize(Integer.parseInt(pagelimit));
        }
        if(!StringUtil.isEmpty(type)){
            technicalSearch.setTechType(type);
        }
        mov.addObject("totalCount",techShareService.getCountByPage(technicalSearch).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("techList",techShareService.getTechByPage(technicalSearch).get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("technical/tech_share");
        return mov;
    }

    @RequestMapping("/shareTechDetail")
    public ModelAndView shareTechDetail(int technicalId){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("techTypes",techShareService.getTechTypes().get(ResponseConfig.RSP_CONTENT));
        mov.addObject("techdetail",techShareService.geetTechDetail(technicalId).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("aliPay",userService.getConfigValue("PayAli").get(ResponseConfig.RSP_CONTENT));
        mov.addObject("wehcatPay",userService.getConfigValue("PayWechat").get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("technical/tech_share_detail");
        return mov;
    }

    @RequestMapping("/diary")
    public ModelAndView diary(String pageIndex,String pagelimit){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("diarytimeLines",diaryService.getNearlyDiarys(3).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("totalCount",diaryService.getDiaryCount().get(ResponseConfig.RSP_CONTENT));
        PageSearch search = new PageSearch();
        if(!StringUtil.isEmpty(pageIndex)){
            search.setCur(Integer.parseInt(pageIndex));
        }
        if(!StringUtil.isEmpty(pagelimit)){
            search.setSize(Integer.parseInt(pagelimit));
        }
        mov.addObject("diarys",diaryService.getDiaryList(search).get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("diary/fleeting_years");
        return mov;
    }

    @RequestMapping("/diaryDetail")
    public ModelAndView diaryDetail(String diaryId){
        ModelAndView mov = new ModelAndView();
        mov.addObject("diaryId",diaryId);
        mov.setViewName("diary/diary_detail");
        return mov;
    }

    @RequestMapping("/dotaDiary")
    public ModelAndView dotaDiary(){
        ModelAndView mov = new ModelAndView();
        mov.setViewName("dota/dota_diary");
        return mov;
    }

    @RequestMapping("/dotaDiaryDetail")
    public ModelAndView dotaDiaryDetail(String dotaDiaryId){
        ModelAndView mov = new ModelAndView();
        mov.addObject("dotaDiaryId",dotaDiaryId);
        mov.setViewName("dota/dota_diary_detail");
        return mov;
    }

    @RequestMapping("/book")
    public ModelAndView book(){
        ModelAndView mov = new ModelAndView();
        mov.setViewName("book/book");
        return mov;
    }


    @RequestMapping("/bookDetail")
    public ModelAndView bookDetail(String bookId){
        ModelAndView mov = new ModelAndView();
        mov.addObject("bookId",bookId);
        mov.setViewName("book/book_detail");
        return mov;
    }

    @RequestMapping("/project")
    public ModelAndView project(){
        ModelAndView mov = new ModelAndView();
        mov.setViewName("project/project");
        return mov;
    }
}
