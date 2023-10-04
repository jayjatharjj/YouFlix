CReATe TABLe IF NOT eXIsTs episode (
    episode_id INT pRImARY KeY,
    seasonid INT,
    episodeno INT,
    episodeposterid INT,
    episodelinkid INT,
    episoderuntime INT
);

CReATe TABLe IF NOT eXIsTs episoderate (
    episoderate_id INT pRImARY KeY,
    episodeid INT,
    userid INT,
    rating INT,
    review TeXT
);

CReATe TABLe IF NOT eXIsTs genre (
    genre_id INT pRImARY KeY AuTO_INCRemeNT,
    genre vARCHAR(255)
);

CReATe TABLe IF NOT eXIsTs movie (
    movie_id INT pRImARY KeY AuTO_INCRemeNT,
    moviename vARCHAR(255),
    movieposterid INT,
    movielinkid INT,
    moviegenreid INT,
    moviesummary TeXT,
    movieruntime INT
);

CReATe TABLe IF NOT eXIsTs movierate (
    movierate_id INT pRImARY KeY,
    userid INT,
    movieid INT,
    rating INT,
    review TeXT
);

CReATe TABLe IF NOT eXIsTs poster (
    poster_id INT pRImARY KeY AuTO_INCRemeNT,
    posterimage vARCHAR(255)
);

CReATe TABLe IF NOT eXIsTs question (
    question_id INT pRImARY KeY,
    question vARCHAR(255)
);

CReATe TABLe IF NOT eXIsTs season (
    season_id INT pRImARY KeY,
    seasonno INT,
    webseriesid INT
);

CReATe TABLe IF NOT eXIsTs `user` (
    user_id INT pRImARY KeY AuTO_INCRemeNT,
    username vARCHAR(255),
    phnno BIgINT,
    role vARCHAR(255),
    password vARCHAR(255),
    quesid INT,
    answer vARCHAR(255),
    islogged BOOLeAN
);

CReATe TABLe IF NOT eXIsTs video (
    video_id INT pRImARY KeY AuTO_INCRemeNT,
    videolink vARCHAR(255)
);

CReATe TABLe IF NOT eXIsTs webrate (
    webrate_id INT pRImARY KeY,
    webseriesid INT,
    userid INT,
    rating INT,
    review TeXT
);

CReATe TABLe IF NOT eXIsTs webseries (
    webseries_id INT pRImARY KeY,
    webseriesname vARCHAR(255),
    webseriesposterid INT,
    webseriessummary TeXT,
    webseriesgenreid INT
);

ALTeR TABLe episode
ADD FOReIgN KeY (seasonid)
ReFeReNCes season(season_id);

ALTeR TABLe movierate
ADD FOReIgN KeY (movieid)
ReFeReNCes movie(movie_id);

ALTeR TABLe movierate
ADD FOReIgN KeY (userid)
ReFeReNCes user(user_id);

ALTeR TABLe movie
ADD FOReIgN KeY (moviegenreid)
ReFeReNCes genre(genre_id);

ALTeR TABLe season
ADD FOReIgN KeY (webseriesid)
ReFeReNCes webseries(webseries_id);

ALTeR TABLe webrate
ADD FOReIgN KeY (webseriesid)
ReFeReNCes webseries(webseries_id);

ALTeR TABLe webrate
ADD FOReIgN KeY (userid)
ReFeReNCes user(user_id);

ALTeR TABLe movie
ADD FOReIgN KeY (movieposterid)
ReFeReNCes poster(poster_id);

ALTeR TABLe movie
ADD FOReIgN KeY (movieposterid)
ReFeReNCes poster(poster_id);

ALTeR TABLe webseries
ADD FOReIgN KeY (webseriesposterid)
ReFeReNCes poster(poster_id);

ALTeR TABLe movie
ADD FOReIgN KeY (movielinkid)
ReFeReNCes video(video_id);

ALTeR TABLe webseries
ADD FOReIgN KeY (webseriesgenreid)
ReFeReNCes genre(genre_id);

ALTeR TABLe episoderate
ADD FOReIgN KeY (userid)
ReFeReNCes user(user_id);

ALTeR TABLe episode
ADD FOReIgN KeY (episodeposterid)
ReFeReNCes poster(poster_id);

ALTeR TABLe episode
ADD FOReIgN KeY (episodelinkid)
ReFeReNCes video(video_id);

ALTeR TABLe user
ADD FOReIgN KeY (quesid)
ReFeReNCes question(question_id);

ALTeR TABLe episoderate
ADD FOReIgN KeY (episodeid)
ReFeReNCes episode(episode_id);

INSERT INTO question
VALUES
	(1,'What is your pet name'),
    (2,'What is your favorite color'),
    (3,"What is your mother's maiden name"),
    (4,'What city were you born in'),
    (5,'What is your favorite book');
