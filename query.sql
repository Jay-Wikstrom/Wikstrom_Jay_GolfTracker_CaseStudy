CREATE TABLE IF NOT EXISTS `courses` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `courseLocation` varchar(255) DEFAULT NULL,
    `courseName` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `ratings` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `courseName` varchar(255) NOT NULL,
    `courseRating` int(11) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `role` (
    `id` bigint(20) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `scores` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `courseName` varchar(255) NOT NULL,
    `courseScore` int(11) NOT NULL,
    `date` date NOT NULL,
    `userScore` int(11) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `user` (
    `id` bigint(20) NOT NULL,
    `email` varchar(255) NOT NULL,
    `firstName` varchar(255) DEFAULT NULL,
    `lastName` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKe6gkqunxajvyxl5uctpl2vl2p` (`email`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `userratings` (
    `ratingsId` int(11) NOT NULL,
    `userId` bigint(20) NOT NULL,
    PRIMARY KEY (`ratingsId`,`userId`),
    KEY `FK9whwetmwxpgjdeam4rjdl3j92` (`userId`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `userscores` (
    `scoresId` int(11) NOT NULL,
    `userId` bigint(20) NOT NULL,
    PRIMARY KEY (`scoresId`,`userId`),
    KEY `FKo4yx7si9qvvuc5hjpwo50jjwf` (`userId`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `user_roles` (
    `user_id` bigint(20) NOT NULL,
    `role_id` bigint(20) NOT NULL,
    KEY `FKbhgxpici80n5kpvs65q90ou14` (`role_id`),
    KEY `FKhlmdr3u7pdi6gfd47cgcb4p6t` (`user_id`)
    ) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO courses (courseName, courseLocation)
VALUES ("Cedar Creek GC", "Albertville"),
       ("Green Haven GC", "Anoka"),
       ("Valleywood GC", "Apple Valley"),
       ("TPC Twin Cities", "Blaine"),
       ("Victory Links GC", "Blaine"),
       ("Dwan GC", "Bloomington"),
       ("Minnesota Valley CC", "Bloomington"),
       ("Centerbrook GC", "Brooklyn Center"),
       ("Brookland Golf Park", "Brooklyn Park"),
       ("Edinburgh USA", "Green Brooklyn Park"),
       ("Buffalo Heights GC", "Buffalo"),
       ("Wild Marsh GC", "Buffalo"),
       ("Birnamwood Public GC", "Burnsville"),
       ("Hidden Haven GC", "Cedar"),
       ("Halla Greens", "Chanhassen"),
       ("Bluff Creek", "Chaska"),
       ("Chaska Par 30", "Chaska"),
       ("Chaska Town Course", "Chaska"),
       ("Dahlgreen", "Chaska"),
       ("Hazeltine National", "Chaska"),
       ("Bunker Hillsa", "Coon Rapids"),
       ("River Oaks Municipal", "Cottage Grove"),
       ("Daytona", "Dayton"),
       ("Dellwood", "Dellwood"),
       ("White Bear Yacht Club", "Dellwood"),
       ("Lost Spur", "Eagan"),
       ("Bearpath", "Eden Prairie"),
       ("Bent Creek", "Eden Prairie"),
       ("Olympic Hills", "Eden Prairie"),
       ("Braemar", "Edina"),
       ("Edina CC", "Edina"),
       ("Interlachen ", "Edina"),
       ("Elk River GC", "Elk River"),
       ("Fountain Valley", "Farmington"),
       ("Southern Hills", "Farmington"),
       ("Castlewood Golf", "Forest Lake"),
       ("Forest Hills GC", "Forest Lake"),
       ("Tanners Brook", "Forest Lake"),
       ("Fort Snelling Public GC", "Fort Snelling"),
       ("Brookview", "Golden Valley"),
       ("Golden Valley", "Golden Valley"),
       ("Theodore Wirth", "Golden Valley"),
       ("Majestic Oaks", "Ham Lake"),
       ("Afton Alps", "Hastings"),
       ("Bellwood Oaks", "Hastings"),
       ("Emerald Greens", "Hastings"),
       ("Hastings", "Hastings"),
       ("Hidden Greens", "Hastings"),
       ("Meadowbrook", "Hopkins"),
       ("Oak Ridge", "Hopkins"),
       ("HghtsInver Wood ", "Inver Grove"),
       ("Ridges at Sand Creek", "Jordan"),
       ("Royal GC", "Lake Elmo"),
       ("Brackett’s Crossing", "Lakeville"),
       ("Crystal Lake", "Lakeville"),
       ("Heritage Links", "Lakeville"),
       ("Chomonix", "Lino Lakes"),
       ("Rush Creek", "Maple Grove"),
       ("Sundance", "Maple Grove"),
       ("Pioneer Creek", "Maple Plain"),
       ("Goodrich", "Maplewood"),
       ("Keller", "Maplewood"),
       ("The Ponds at Battle Creek", "Maplewood"),
       ("Baker National", "Medina"),
       ("Evergreen", "Medina"),
       ("Medina G&CC", "Medina"),
       ("Mendakota CC", "Mendota Heights"),
       ("Somerset", "Mendota Heights"),
       ("Columbia GC", "Minneapolis"),
       ("Gross National GC", "Minneapolis"),
       ("Hiawatha GC", "Minneapolis"),
       ("The Minikahda Club", "Minneapolis"),
       ("Minneapolis GC", "Minneapolis"),
       ("Glen Lake Golf", "Minnetonka"),
       ("Beach Lafayette Club", "Minnetonka"),
       ("Burl Oaks GC", "Minnetrista"),
       ("Brightwood Hills", "New Brighton"),
       ("New Hope Village GC", "New Hope"),
       ("North Oaks GC", "North Oaks"),
       ("Refuge GC", "Oak Grove"),
       ("Oak Marsh GC", "Oakdale"),
       ("Riverwood Nationala", "Otsego"),
       ("Eagle Lake Youth", "Plymouth"),
       ("Hollydale", "Plymouth"),
       ("Cleary Lake Park", "Prior Lake"),
       ("Legends Club", "Prior Lake"),
       ("The Meadows at Mystic Lake", "Prior Lake"),
       ("The Wilds", "Prior Lake"),
       ("The Links at Northfork", "Ramsey"),
       ("Rum River Hills", "Ramsey"),
       ("Rich Valley", "Rosemount"),
       ("Midland Hills", "Roseville"),
       ("Roseville Cedarholm", "Roseville"),
       ("Stonebrooke", "Shakopee"),
       ("The Ponds", "St. Francis"),
       ("Fox Hollow", "St. Michael"),
       ("Como GC", "St. Paul"),
       ("Highland National", "St. Paul"),
       ("Phalen Park", "St. Paul"),
       ("Town & Country Club", "St. Paul"),
       ("Les Bolstad GC", "St. Paul"),
       ("Indian Hills", "Stillwater"),
       ("Loggers Trail", "Stillwater"),
       ("Oak Glen", "Stillwater"),