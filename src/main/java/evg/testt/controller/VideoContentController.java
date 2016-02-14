package evg.testt.controller;

import evg.testt.model.content.*;
import evg.testt.service.videoservices.MovieService;
import evg.testt.service.videoservices.VideoService;
import evg.testt.service.videoservices.TvShowService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/video")
public class VideoContentController {

    @Autowired
    MovieService movieService;
    @Autowired
    VideoService videoService;
    @Autowired
    TvShowService tvShowService;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String redirectToMovie() {
        return "redirect:/video/movie";
    }

    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public ModelAndView videoVideo(@RequestParam(required = false) String id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_PLAY);
        List<Video> listVideoFiles = videoService.getAll();
        modelAndView.addObject("content", listVideoFiles);
        Video playVideo = null;
        if (id != null) {
            playVideo = videoService.get(Long.parseLong(id));
        }
        modelAndView.addObject("playVideo", playVideo);
        modelAndView.addObject("type", "video");
        modelAndView.addObject("typeName", "Video");
        return modelAndView;
    }


    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public ModelAndView videoMovie(@RequestParam(required = false) String id,
                         @RequestParam(required = false) String serie) throws MalformedURLException {
        ModelAndView modelAndView;
        if (id != null) {
            Movie movie = movieService.get(Long.parseLong(id));
            modelAndView = new ModelAndView(JspPath.VIDEO_PLAY, "content", movie);
            if (serie != null) {
                List<VideoFile> listVideoFiles = movieService.get(Long.parseLong(id)).getListVideoFiles();
                VideoFile playVideo = null;
                for (VideoFile videoFile: listVideoFiles) {
                    if (videoFile.getSerieNumber().equals(Integer.parseInt(serie))) {
                        playVideo = videoFile;
                    }
                }
                modelAndView.addObject("playVideo", playVideo);
            }
        } else {
            modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
            List<Movie> contentList = movieService.getAll();
            modelAndView.addObject("contents", contentList);
        }
        modelAndView.addObject("type", "movie");
        modelAndView.addObject("typeName", "Movie");
        return modelAndView;
    }

    @RequestMapping(value = "/tvshow", method = RequestMethod.GET)
    public ModelAndView videoTvShow(@RequestParam(required = false) String id,
                            @RequestParam(required = false) String season) throws MalformedURLException {
        ModelAndView modelAndView;
        if (id != null) {
            if (season == null) {
                modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
                List<Season> seasonList = tvShowService.get(Long.parseLong(id)).getSeason();
                modelAndView.addObject("contents", seasonList);
                modelAndView.addObject("id", id);
            }
            else {
                modelAndView = new ModelAndView(JspPath.VIDEO_PLAY);
                List<Season> seasonList = tvShowService.get(Long.parseLong(id)).getSeason();
                for (Season oneSeason : seasonList) {
                    if (oneSeason.getSeasonNumber().equals(season)) {
                        modelAndView.addObject("content", oneSeason);
                        break;
                    }
                }
            }
        } else {
            modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
            List<Video> contentList = videoService.getAll();
            modelAndView.addObject("contents", contentList);
            id = "0";
            modelAndView.addObject("id", id);
        }
        modelAndView.addObject("type", "serial");
        modelAndView.addObject("typeName", "Serial");
        return modelAndView;
    }




    /*@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView videoAdmin() {
        List<VideoFile> contentList = videoContentServiceImpl.getAll();
        return new ModelAndView(JspPath.VIDEO_ADMIN, "contents", contentList);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editContent(@RequestParam(required = false) String id) {

        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDIT);
        if (id != null) {
            VideoFile videoFile = videoContentServiceImpl.get(Long.parseLong(id));
            modelAndView.addObject("content", videoFile);
            modelAndView.addObject("contenturl", videoFile.getUrl().toString());
        }

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveContent(@ModelAttribute VideoFile videoFile) {
        videoContentServiceImpl.save(videoFile);
        return "redirect:/video/admin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteVideo(@RequestParam(required = true) String id) {
        videoContentServiceImpl.remove(Long.parseLong(id));
        return "redirect:/video/admin";
    }*/


}
//add object in movie,  in serial,  in tv-show
       /*Video video1 = new Video();
        Video video2 = new Video();
        video1.setName("video_1");
        video1.setDescribe(" describing of video_1");
        video1.setUrl("https://www.youtube.com/embed/ruxvZGMbGI8");
        video2.setName("video_2");
        video2.setDescribe("describing of video_2");
        video2.setUrl("https://www.youtube.com/embed/WmCKo6AofnU");
        videoService.save(video1);
        videoService.save(video2);

        VideoFile videoFile1 = new VideoFile();
        videoFile1.setName("video_1");
        videoFile1.setDescribe(" describing of video_1");
        videoFile1.setUrl("https://www.youtube.com/embed/ruxvZGMbGI8");
        videoFile1.setSerieNumber(1);
        VideoFile videoFile2 = new VideoFile();
        videoFile2.setName("video_2");
        videoFile2.setDescribe("describing of video_2");
        videoFile2.setUrl("https://www.youtube.com/embed/WmCKo6AofnU");
        videoFile2.setSerieNumber(2); List<VideoFile> videoFiles = new ArrayList<>();
        videoFiles.add(videoFile1);
        videoFiles.add(videoFile2);
        Movie movie1 = new Movie();
        movie1.setListVideoFiles(videoFiles);
        movie1.setDescribe(" describing about this MOVIE");
        movie1.setName("My movie #1");
        movieService.save(movie1);

        TvShow tvShow = new TvShow();
        tvShow.setDescribe("This is TV-Show !!");
        tvShow.setName("TV-Show about something..");
        List<Season> seasons = new ArrayList<>();
        Season season1 = new Season();
        season1.setDescribe(" about this season #1");
        season1.setName("season #1");
        season1.setSeasonNumber(1);
        season1.setListVideoFiles(videoFiles);
        Season season2 = new Season();
        season2.setDescribe(" about this season #2");
        season2.setName("season #2");
        season2.setSeasonNumber(2);
        season2.setListVideoFiles(videoFiles);
        seasons.add(season1);
        seasons.add(season2);
        tvShow.setSeason(seasons);
        tvShowService.save(tvShow); */
