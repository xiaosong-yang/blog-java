package yyf256.top.blog.pageController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import yyf256.top.blog.bean.TechnicalSearch;
import yyf256.top.blog.config.ResponseConfig;
import yyf256.top.blog.service.*;
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

    @Autowired
    DotaService dotaService;

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
    public ModelAndView diaryDetail(int diaryId){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("diarytimeLines",diaryService.getNearlyDiarys(3).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("diaryDetal",diaryService.getDiarysDetail(diaryId).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("diaryId",diaryId);
        mov.addObject("aliPay",userService.getConfigValue("PayAli").get(ResponseConfig.RSP_CONTENT));
        mov.addObject("wehcatPay",userService.getConfigValue("PayWechat").get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("diary/diary_detail");
        return mov;
    }

    @RequestMapping("/dotaDiary")
    public ModelAndView dotaDiary(String pageIndex,String pagelimit){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("dotaTimeLines",dotaService.getDotaTimeLine(5).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("totalCount",dotaService.getDotaDiaryCountByPage().get(ResponseConfig.RSP_CONTENT));
        PageSearch pageSearch = new PageSearch();
        if(!StringUtil.isEmpty(pageIndex)){
            pageSearch.setCur(Integer.parseInt(pageIndex));
        }
        if(!StringUtil.isEmpty(pagelimit)){
            pageSearch.setSize(Integer.parseInt(pagelimit));
        }
        mov.addObject("dotas",dotaService.getDotaDiaryByPage(pageSearch).get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("dota/dota_diary");
        return mov;
    }

    @RequestMapping("/dotaDiaryDetail")
    public ModelAndView dotaDiaryDetail(int dotaDiaryId){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("dotaTimeLines",dotaService.getDotaTimeLine(5).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("dotaDiaryId",dotaDiaryId);
        mov.addObject("dotaDetal",dotaService.getDotaDetail(dotaDiaryId).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("aliPay",userService.getConfigValue("PayAli").get(ResponseConfig.RSP_CONTENT));
        mov.addObject("wehcatPay",userService.getConfigValue("PayWechat").get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("dota/dota_diary_detail");
        return mov;
    }

    @RequestMapping("/book")
    public ModelAndView book(String pageIndex,String pagelimit){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("nearlyBooks",bookService.getNearlyBooks(5).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("totalCount",bookService.getBooksCount().get(ResponseConfig.RSP_CONTENT));
        PageSearch pageSearch = new PageSearch();
        if(!StringUtil.isEmpty(pageIndex)){
            pageSearch.setCur(Integer.parseInt(pageIndex));
        }
        if(!StringUtil.isEmpty(pagelimit)){
            pageSearch.setSize(Integer.parseInt(pagelimit));
        }
        mov.addObject("books",bookService.getBooksByPage(pageSearch).get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("book/book");
        return mov;
    }


    @RequestMapping("/bookDetail")
    public ModelAndView bookDetail(int bookId){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.addObject("nearlyBooks",bookService.getNearlyBooks(5).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("bookDetail",bookService.getBookDetail(bookId).get(ResponseConfig.RSP_CONTENT));
        mov.addObject("aliPay",userService.getConfigValue("PayAli").get(ResponseConfig.RSP_CONTENT));
        mov.addObject("wehcatPay",userService.getConfigValue("PayWechat").get(ResponseConfig.RSP_CONTENT));
        mov.setViewName("book/book_detail");
        return mov;
    }

    @RequestMapping("/project")
    public ModelAndView project(){
        ModelAndView mov = new ModelAndView();
        addRight(mov);
        mov.setViewName("project/project");
        return mov;
    }
}
