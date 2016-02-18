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


    //Movie administrate

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
        ModelAndView modelAndView;
        //if serieNumber != null then we recive query for updating one serie in movie
        if (serieNumber != null) {
            modelAndView = new ModelAndView(JspPath.VIDEO_EDITSERIE);
            VideoFile videoFile = new VideoFile();
            List<VideoFile> videoFiles = movieService.get(Long.parseLong(id)).getListVideoFiles();
            for (int i = 0; i < videoFiles.size(); i++) {
                if (videoFiles.get(i).getSerieNumber().equals(Integer.parseInt(serieNumber))) {
                    videoFile = videoFiles.get(i);
                }
            }
            modelAndView.addObject("content", videoFile);
            modelAndView.addObject("id", id);
        } else {
            modelAndView = new ModelAndView(JspPath.VIDEO_EDIT);
            if (id != null) {
                Movie movie = movieService.get(Long.parseLong(id));
                modelAndView.addObject("content", movie);
            }
        }
        modelAndView.addObject("type", "movie");
        return modelAndView;
    }


    @RequestMapping(value = "/movie/save", method = RequestMethod.POST)
    public String saveMovie(@ModelAttribute Movie newcontent) {
            Movie movie = new Movie();
            Long id;
            if ((id = newcontent.getId()) != null) {
                movie = movieService.get(id);
            }
            movie.setDescribe(newcontent.getDescribe());
            movie.setName(newcontent.getName());
            movieService.save(movie);

        return "redirect:/video/movie/admin";
    }

    @RequestMapping(value = "/movie/saveserie", method = RequestMethod.POST)
    public String saveserie(@ModelAttribute VideoFile newcontent,
                            @RequestParam(required = true) String id) {
        Movie movie = movieService.get(Long.parseLong(id));
        List<VideoFile> videoFiles = movie.getListVideoFiles();
        Boolean isNewSerie = true;
        for (int i=0; i < videoFiles.size(); i++) {
            if (videoFiles.get(i).getSerieNumber().equals(newcontent.getSerieNumber())) {
                isNewSerie = false;
                VideoFile videoFile = new VideoFile();
                videoFile.setName(newcontent.getName());
                videoFile.setDescribe(newcontent.getDescribe());
                videoFile.setUrl(newcontent.getUrl());
                videoFile.setSerieNumber(newcontent.getSerieNumber());
                videoFiles.set(i, videoFile);
            }
        }
        if (isNewSerie) {
            videoFiles.add(newcontent);
        }
        movie.setListVideoFiles(videoFiles);
        movieService.save(movie);

        return "redirect:/video/movie/admin?id="+id;
    }


    @RequestMapping(value = "/movie/addSerie", method = RequestMethod.POST)
    public ModelAndView addSerie(@RequestParam(required = true) String id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDITSERIE, "id", id);
        modelAndView.addObject("type", "movie");
        return modelAndView;
    }


    //TV-Show administrate


    @RequestMapping(value = "/tvshow/admin", method = RequestMethod.GET)
    public ModelAndView videoTvShow(@RequestParam(required = false) String id,
                                    @RequestParam(required = false) String season) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_ADMIN);
        if (season != null) {
            List<Season> seasons = tvShowService.get(Long.parseLong(id)).getSeason();
            for (Season season1: seasons) {
                if (season1.getSeasonNumber().equals(Integer.parseInt(season))) {



                    modelAndView = new ModelAndView(JspPath.VIDEO_ADMINSERIE);
                    modelAndView.addObject("id", id);
                    modelAndView.addObject("seasonNumber", season);
                    modelAndView.addObject("contents", season1.getListVideoFiles());
                }
            }
        }
        else if (id != null){
            List<Season> seasons = tvShowService.get(Long.parseLong(id)).getSeason();
            modelAndView.addObject("contents", seasons);
            modelAndView.addObject("id", id);
        } else {
            List<TvShow> contentList = tvShowService.getAll();
            modelAndView.addObject("contents", contentList);
        }
        modelAndView.addObject("type", "tvshow");
        modelAndView.addObject("typeName", "TV-Show");
        return modelAndView;
    }


    @RequestMapping(value = "/tvshow/delete", method = RequestMethod.POST)
    public String deleteTvShow(@RequestParam(required = true) String id,
                               @RequestParam(required = false) String seasonNumber) {
        String wayOut;
        if (seasonNumber != null) {
            TvShow tvShow = tvShowService.get(Long.parseLong(id));
            List<Season> seasons = tvShow.getSeason();
            for (int i = 0; i < seasons.size(); i++) {
                if (seasons.get(i).getSeasonNumber().equals(Integer.parseInt(seasonNumber))) {
                    seasons.remove(i);
                }
            }
            tvShow.setSeason(seasons);
            tvShowService.save(tvShow);
            wayOut = "redirect:/video/tvshow/admin?id="+id;
        } else {
            tvShowService.remove(Long.parseLong(id));
            wayOut = "redirect:/video/tvshow/admin";
        }
        return wayOut;
    }

    @RequestMapping(value = "/tvshow/update", method = RequestMethod.POST)
    public ModelAndView updateTvShow(@RequestParam(required = false) String id,
                                     @RequestParam(required = false) String seasonNumber) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDIT);
        if (seasonNumber != null) {
            modelAndView = new ModelAndView(JspPath.VIDEO_EDITSEASON);
            Season season = null;
            List<Season> seasons = tvShowService.get(Long.parseLong(id)).getSeason();
            for (Season seas : seasons) {
                if (seas.getSeasonNumber().equals(Integer.parseInt(seasonNumber))) {
                    season = seas;
                }
            }
            modelAndView.addObject("content", season);
            modelAndView.addObject("id", id);
        }
        else if (id != null) {
            TvShow tvShow = tvShowService.get(Long.parseLong(id));
            modelAndView.addObject("content", tvShow);
        }
        modelAndView.addObject("type", "tvshow");
        return modelAndView;
    }

    @RequestMapping(value = "/tvshow/save", method = RequestMethod.POST)
    public String saveTvShow(@ModelAttribute Movie newcontent,
                             @RequestParam(required = false) String seasonNumber) {
        TvShow tvShowOut = new TvShow();
        if (seasonNumber != null) {
            TvShow tvShow = tvShowService.get(newcontent.getId());
            List<Season> seasons = tvShow.getSeason();
            for (int i=0; i < seasons.size(); i++) {
                if (seasons.get(i).getSeasonNumber().equals(Integer.parseInt(seasonNumber))) {
                    seasons.get(i).setName(newcontent.getName());
                    seasons.get(i).setDescribe(newcontent.getDescribe());
                }
            }
            tvShow.setSeason(seasons);
            tvShowService.save(tvShow);
        }
        else {
            Long id;
            if ((id = newcontent.getId()) != null) {
                tvShowOut = tvShowService.get(id);
            }
        }
        tvShowOut.setDescribe(newcontent.getDescribe());
        tvShowOut.setName(newcontent.getName());
        tvShowService.save(tvShowOut);
        return "redirect:/video/tvshow/admin";
    }

    @RequestMapping(value = "/tvshow/addSeason", method = RequestMethod.POST)
    public ModelAndView addSeason(@RequestParam(required = true) String id) {
        ModelAndView modelAndView = new ModelAndView(JspPath.VIDEO_EDITSEASON, "id", id);
        modelAndView.addObject("type", "tvshow");
        return modelAndView;
    }

    @RequestMapping(value = "/tvshow/saveseason", method = RequestMethod.POST)
    public String saveSeason(@ModelAttribute Season newcontent,
                             @RequestParam(required = true) String id) {
        TvShow tvShow = tvShowService.get(Long.parseLong(id));
        List<Season> seasons = tvShow.getSeason();
        Boolean isNew = true;
        for (int i=0; i < seasons.size(); i++) {
            if (seasons.get(i).getSeasonNumber().equals(newcontent.getSeasonNumber())) {
                isNew = false;
                seasons.set(i, newcontent);
            }
        }
        if (isNew) {
            seasons.add(newcontent);
        }
        tvShow.setSeason(seasons);
        tvShowService.save(tvShow);
        return "redirect:/video/tvshow/admin?id="+id;
    }


    @RequestMapping(value = "/tvshow/saveserie", method = RequestMethod.POST)
    public String saveSerie(@ModelAttribute VideoFile newcontent,
                            @RequestParam(required = true) String id,
                            @RequestParam(required = true) String seasonNumber) {




        return null;
    }

    @RequestMapping(value = "/tvshow/deleteserie", method = RequestMethod.POST)
    public String saveSerie(@RequestParam(required = true) String id,
                            @RequestParam(required = true) String seasonNumber,
                            @RequestParam(required = true) String serieNumber) {
        TvShow tvShow = tvShowService.get(Long.parseLong(id));
        List<Season> seasonList = tvShow.getSeason();

        for (int i = 0; i < seasonList.size(); i++) {
            if (seasonList.get(i).getSeasonNumber().equals(Integer.parseInt(seasonNumber))) {
                List<VideoFile> videoFiles = seasonList.get(i).getListVideoFiles();
                for (int j = 0; j < videoFiles.size(); j++) {
                    if (videoFiles.get(j).getSerieNumber().equals(Integer.parseInt(serieNumber))) {
                        videoFiles.remove(j);
                        seasonList.get(i).setListVideoFiles(videoFiles);
                        tvShow.setSeason(seasonList);
                        tvShowService.save(tvShow);
                    }
                }
            }
        }
        return "redirect:/video/tvshow/admin?id="+id+"&season="+seasonNumber;
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
