package evg.testt.controller;

import evg.testt.model.content.*;
import evg.testt.service.videoservices.MovieService;
import evg.testt.service.videoservices.VideoService;
import evg.testt.service.videoservices.TvShowService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
                         @RequestParam(required = false) String serie){
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
                            @RequestParam(required = false) String season,
                            @RequestParam(required = false) String serie) {
        ModelAndView modelAndView;
        if (id != null) {
            List<Season> seasonList = tvShowService.get(Long.parseLong(id)).getSeason();
            if (season == null) {
                modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
                modelAndView.addObject("contents", seasonList);
            }
            else {
                modelAndView = new ModelAndView(JspPath.VIDEO_PLAY);
                Season currentSeason = null;
                for (Season oneSeason : seasonList) {
                    if (oneSeason.getSeasonNumber().equals(Integer.parseInt(season))) {
                        currentSeason = oneSeason;
                        break;
                    }
                }
                modelAndView.addObject("content", currentSeason);
                if (serie != null) {
                    VideoFile playVideo = null;
                    for (VideoFile videoFile: currentSeason.getListVideoFiles()) {
                        if (videoFile.getSerieNumber().equals(Integer.parseInt(serie))) {
                            playVideo = videoFile;
                        }
                    }
                    modelAndView.addObject("playVideo", playVideo);
                }
            }
        } else {
            modelAndView = new ModelAndView(JspPath.VIDEO_ALL);
            List<TvShow> contentList = tvShowService.getAll();
            modelAndView.addObject("contents", contentList);
            id = "0";
        }
        modelAndView.addObject("id", id);
        modelAndView.addObject("type", "tvshow");
        modelAndView.addObject("typeName", "TV-Show");
        return modelAndView;
    }




    @RequestMapping(value = "/video/admin", method = RequestMethod.GET)
    public ModelAndView videoAdmin(@RequestParam(required = false) String id) {
        List<Video> contentList = videoService.getAll();
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_ADMIN, "contents", contentList);
        modelAndView.addObject("type", "video");
        modelAndView.addObject("typeName", "Video");
        return modelAndView;
    }

    @RequestMapping(value = "/video/delete", method = RequestMethod.POST)
    public String deleteVideo(@RequestParam(required = true) String id) {
        videoService.remove(Long.parseLong(id));
        return "redirect:/video/video/admin";
    }

    @RequestMapping(value = "/video/update", method = RequestMethod.POST)
    public ModelAndView updateVideo(@RequestParam(required = false) String id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDIT);
        if (id != null) {
            Video videoFile = videoService.get(Long.parseLong(id));
            modelAndView.addObject("content", videoFile);
        }
        modelAndView.addObject("type", "video");
        return modelAndView;
    }

    @RequestMapping(value = "/video/save", method = RequestMethod.POST)
    public String saveVideo(@ModelAttribute Video newcontent) {
        videoService.save(newcontent);
        return "redirect:/video/video/admin";
    }

    @RequestMapping(value = "/movie/admin", method = RequestMethod.GET)
    public ModelAndView videoMovie(@RequestParam(required = false) String id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_ADMIN);
        if (id != null) {
            List<VideoFile> videoFiles = movieService.get(Long.parseLong(id)).getListVideoFiles();
            modelAndView.addObject("contents", videoFiles);
            modelAndView.addObject("id", id);
        }
        else {
            List<Movie> contentList = movieService.getAll();
            modelAndView.addObject("contents", contentList);
        }
        modelAndView.addObject("type", "movie");
        modelAndView.addObject("typeName", "Movie");
        return modelAndView;
    }

    @RequestMapping(value = "/movie/delete", method = RequestMethod.POST)
    public String deleteMovie(@RequestParam(required = true) String id,
                              @RequestParam(required = false) String serieNumber) {
        if (serieNumber != null) {
            Movie movie = movieService.get(Long.parseLong(id));
            List<VideoFile> videoFiles = movie.getListVideoFiles();
            for (int i = 0; i < videoFiles.size(); i++) {
                if (videoFiles.get(i).getSerieNumber().equals(Integer.parseInt(serieNumber))) {
                    videoFiles.remove(i);
                }
            }
            movie.setListVideoFiles(videoFiles);
            movieService.save(movie);
        } else {
            movieService.remove(Long.parseLong(id));
        }
        return "redirect:/video/movie/admin";
    }

    @RequestMapping(value = "/movie/update", method = RequestMethod.POST)
    public ModelAndView updateMovie(@RequestParam(required = false) String id,
                                    @RequestParam(required = false) String serieNumber) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDIT);
        /*if (serieNumber != null) {
            VideoFile videoFile = new VideoFile();
            List<VideoFile> videoFiles = movieService.get(Long.parseLong(id)).getListVideoFiles();
            for (int i = 0; i < videoFiles.size(); i++) {
                if (videoFiles.get(i).getSerieNumber().equals(Integer.parseInt(serieNumber))) {
                    videoFile = videoFiles.get(i);
                }
            }
            modelAndView.addObject("content", videoFile);
            modelAndView.addObject("id", id);
        } else {*/
            if (id != null) {
                Movie movie = movieService.get(Long.parseLong(id));
                modelAndView.addObject("content", movie);
            }

        modelAndView.addObject("type", "movie");
        return modelAndView;
    }

    @RequestMapping(value = "/movie/save", method = RequestMethod.POST)
    public String saveMovie(@ModelAttribute Movie newcontent,
                            @RequestParam(required = false) String serieNumber,
                            @RequestParam(required = false) String url) {
    //if (serieNumber != null) then we resive a video file
        /*if (serieNumber != null) {
            Movie movie = movieService.get(newcontent.getId());
            List<VideoFile> videoFiles = movie.getListVideoFiles();
            for (int i = 0; i < videoFiles.size(); i++) {
                if (videoFiles.get(i).getSerieNumber().equals(Integer.parseInt(serieNumber))) {
                    VideoFile videoFile = new VideoFile();
                    videoFile.setName(newcontent.getName());
                    videoFile.setDescribe(newcontent.getDescribe());
                    videoFile.setUrl(url);
                    videoFile.setSerieNumber(Integer.parseInt(serieNumber));
                    videoFiles.set(i, videoFile);
                }
            }
            movie.setListVideoFiles(videoFiles);
            movieService.save(movie);
        } else {*/
            Movie movie = new Movie();
            Long id = null;
            if ((id = newcontent.getId()) != null) {
                movie = movieService.get(id);
            }
            movie.setDescribe(newcontent.getDescribe());
            movie.setName(newcontent.getName());
            movieService.save(movie);

        return "redirect:/video/movie/admin";
    }






    @RequestMapping(value = "/tvshow/admin", method = RequestMethod.GET)
    public ModelAndView videoTvShow(@RequestParam(required = false) String id) {
        if (id != null){


        }
        List<TvShow> contentList = tvShowService.getAll();
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_ADMIN, "contents", contentList);
        modelAndView.addObject("type", "tvshow");
        modelAndView.addObject("typeName", "TV-Show");
        return modelAndView;
    }

    @RequestMapping(value = "/tvshow/delete", method = RequestMethod.POST)
    public String deleteTvShow(@RequestParam(required = true) String id) {
        tvShowService.remove(Long.parseLong(id));
        return "redirect:/video/tvshow/admin";
    }

    @RequestMapping(value = "/tvshow/update", method = RequestMethod.POST)
    public ModelAndView updateTvShow(@RequestParam(required = false) String id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDIT);
        if (id != null) {
            TvShow tvShow = tvShowService.get(Long.parseLong(id));
            modelAndView.addObject("content", tvShow);
        }
        modelAndView.addObject("type", "tvshow");
        return modelAndView;
    }

    @RequestMapping(value = "/tvshow/save", method = RequestMethod.POST)
    public String saveTvShow(@ModelAttribute Movie newcontent) {
        TvShow tvShow = new TvShow();
        Long id = null;
        if ((id = newcontent.getId()) != null) {
            tvShow = tvShowService.get(newcontent.getId());
        }
        tvShow.setDescribe(newcontent.getDescribe());
        tvShow.setName(newcontent.getName());
        tvShowService.save(tvShow);
        return "redirect:/video/tvshow/admin";
    }







}
//add objects in movie,  in video,  in tv-show
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