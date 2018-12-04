import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

class SQL_Spec extends Specification {
  @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
  
  def setupSpec() {
    sql.execute("create table STATIONS (id int primary key, title6 char(6), title12 char(12), title24 char(24), title38 char(38))")
    sql.execute("insert into STATIONS values \
			 (1,'Белгра','Белград     ','Белград                 ','Белград                               '), \
			 (2,'Белост','Белосток    ','Белосток                ','Белосток                              '), \
			 (3,'БЕРЛИН','БЕРЛИН ЛИХТЕ','БЕРЛИН ЛИХТЕН.          ','БЕРЛИН ЛИХТЕН.                        '), \
			 (4,'Братис','Братислава  ','Братислава              ','Братислава                            '), \
			 (5,'Брюссе','Брюссель    ','Брюссель                ','Брюссель                              '), \
			 (6,'Будапе','Будапешт    ','Будапешт                ','Будапешт                              '), \
			 (7,'Бухаре','Бухарест    ','Бухарест                ','Бухарест                              '), \
			 (8,'Варна ','Варна       ','Варна                   ','Варна                                 '), \
			 (10,'ВАРШАВ','ВАРШАВА ГДАН','ВАРШАВА ГДАНЬСКА        ','ВАРШАВА ГДАНЬСКА                      '), \
			 (11,'Вена  ','Вена        ','Вена                    ','Вена                                  '), \
			 (12,'Венеци','Венеция     ','Венеция                 ','Венеция                               '), \
			 (13,'Вроцла','Вроцлав-Глав','Вроцлав-Главный         ','Вроцлав-Главный                       '), \
			 (14,'Загреб','Загреб      ','Загреб                  ','Загреб                                '), \
			 (16,'Прага ','Прага       ','Прага                   ','Прага                                 '), \
			 (17,'Пхенья','Пхеньян     ','Пхеньян                 ','Пхеньян                               '), \
			 (18,'Салони','Салоники    ','Салоники                ','Салоники                              '), \
			 (19,'София ','София       ','София                   ','София                                 '), \
			 (21,'Франкф','Франкфурт-на','Франкфурт-на-Майне      ','Франкфурт-на-Майне                    '), \
			 (22,'Улан-Б','Улан-Батор  ','Улан-Батор              ','Улан-Батор                            '), \
			 (23,'ЩЕЦИН ','ЩЕЦИН       ','ЩЕЦИН                   ','ЩЕЦИН                                 '), \
			 (24,'Дзамын','Дзамын-Удэ  ','Дзамын-Удэ              ','Дзамын-Удэ                            '), \
			 (26,'ГДЫНЯ ','ГДЫНЯ       ','ГДЫНЯ                   ','ГДЫНЯ                                 '), \
			 (27,'СУХЭ-Б','СУХЭ-БАТОР  ','СУХЭ-БАТОР              ','СУХЭ-БАТОР                            '), \
			 (30,'Париж ','Париж Восточ','Париж Восточный         ','Париж Восточный                       '), \
			 (32,'ТЕРЕСП','ТЕРЕСПОЛЬ   ','ТЕРЕСПОЛЬ               ','ТЕРЕСПОЛЬ                             '), \
			 (34,'СОНБОН','СОНБОН      ','СОНБОН                  ','СОНБОН                                '), \
			 (35,'РАДЖИН','РАДЖИН      ','РАДЖИН                  ','РАДЖИН                                '), \
			 (36,'Дзун-Х','Дзун-Хара   ','Дзун-Хара               ','Дзун-Хара                             '), \
			 (37,'УНСАН ','УНСАН       ','УНСАН                   ','УНСАН                                 '), \
			 (38,'АЛАШАН','АЛАШАНЬХОУ  ','АЛАШАНЬХОУ              ','АЛАШАНЬХОУ                            '), \
			 (45,'МАНДАЛ','МАНДАЛ      ','МАНДАЛ                  ','МАНДАЛ                                '), \
			 (59,'ОРХОН ','ОРХОН       ','ОРХОН                   ','ОРХОН                                 '), \
			 (69,'САЛХИТ','САЛХИТ      ','САЛХИТ                  ','САЛХИТ                                '), \
			 (75,'ТУНХ  ','ТУНХ        ','ТУНХ                    ','ТУНХ                                  '), \
			 (76,'ТОЛГОЙ','ТОЛГОЙТ     ','ТОЛГОЙТ                 ','ТОЛГОЙТ                               '), \
			 (87,'УНЭГТ ','УНЭГТ       ','УНЭГТ                   ','УНЭГТ                                 '), \
			 (96,'ГОРГАН','ГОРГАН      ','ГОРГАН                  ','ГОРГАН                                '), \
			 (100,'Пекин ','Пекин       ','Пекин                   ','Пекин                                 '), \
			 (101,'Эрлянь','Эрлянь      ','Эрлянь                  ','Эрлянь                                '), \
			 (102,'СУЙФЫН','СУЙФЫНХЭ    ','СУЙФЫНХЭ                ','СУЙФЫНХЭ                              '), \
			 (103,'МАНЬЧЖ','МАНЬЧЖУРИЯ  ','МАНЬЧЖУРИЯ              ','МАНЬЧЖУРИЯ                            '), \
			 (104,'ХУНЬЧУ','ХУНЬЧУНЬ    ','ХУНЬЧУНЬ                ','ХУНЬЧУНЬ                              '), \
			 (118,'ШАТАН ','ШАТАН       ','ШАТАН                   ','ШАТАН                                 '), \
			 (124,'ЭНХТАЛ','ЭНХТАЛ      ','ЭНХТАЛ                  ','ЭНХТАЛ                                '), \
			 (127,'ЭМЭЭЛТ','ЭМЭЭЛТ      ','ЭМЭЭЛТ                  ','ЭМЭЭЛТ                                '), \
			 (130,'БЕРЛИН','БЕРЛИН ЗООЛ ','БЕРЛИН ЗООЛ             ','БЕРЛИН ЗООЛ                           '), \
			 (209,'ТУМАНГ','ТУМАНГАН    ','ТУМАНГАН                ','ТУМАНГАН                              '), \
			 (351,'Хельси','Хельсинки   ','Хельсинки               ','Хельсинки                             '), \
			 (358,'КОЛАРИ','КОЛАРИ      ','КОЛАРИ                  ','КОЛАРИ                                '), \
			 (408,'КУОПИО','КУОПИО      ','КУОПИО                  ','КУОПИО                                '), \
			 (511,'Страсб','Страсбург Ви','Страсбург Виле          ','Страсбург Виле                        '), \
			 (602,'ВЕНТИМ','ВЕНТИМИЛЬЯ  ','ВЕНТИМИЛЬЯ              ','ВЕНТИМИЛЬЯ                            '), \
			 (680,'СУХБАА','СУХБААТАР   ','СУХБААТАР               ','СУХБААТАР                             '), \
			 (690,'АКИНА ','АКИНА       ','АКИНА                   ','АКИНА                                 '), \
			 (980,'ХОЙТ  ','ХОЙТ        ','ХОЙТ                    ','ХОЙТ                                  '), \
			 (990,'5 КМ  ','5 КМ        ','5 КМ                    ','5 КМ                                  '), \
			 (991,'КРАКОВ','КРАКОВ      ','КРАКОВ                  ','КРАКОВ                                '), \
			 (992,'ОЛЬШТЫ','ОЛЬШТЫН     ','ОЛЬШТЫН                 ','ОЛЬШТЫН                               '), \
			 (993,'ЖЕПИН ','ЖЕПИН       ','ЖЕПИН                   ','ЖЕПИН                                 '), \
			 (994,'ГДАНЬС','ГДАНЬСК ГЛ. ','ГДАНЬСК ГЛ.             ','ГДАНЬСК ГЛ.                           '), \
			 (995,'БРАНЕВ','БРАНЕВО     ','БРАНЕВО                 ','БРАНЕВО                               '), \
			 (996,'СКАНДА','СКАНДАВА    ','СКАНДАВА                ','СКАНДАВА                              '), \
			 (1011,'ПЕТРОЗ','ПЕТРОЗАВОДСК','ПЕТРОЗАВОДСК-ГОЛ        ','ПЕТРОЗАВОДСК-ГОЛ                      '), \
			 (1012,'ПЕТРОЗ','ПЕТРОЗАВОДСК','ПЕТРОЗАВОДСК-ТОМ        ','ПЕТРОЗАВОДСК-ТОМ                      '), \
			 (1020,'ГОЛИКО','ГОЛИКОВКА   ','ГОЛИКОВКА               ','ГОЛИКОВКА                             '), \
			 (1022,'СУЙФЫН','СУЙФЫНХЕ    ','СУЙФЫНХЕ                ','СУЙФЫНХЕ                              '), \
			 (1031,'ШУЙСКИ','ШУЙСКИЙ МОСТ','ШУЙСКИЙ МОСТ            ','ШУЙСКИЙ МОСТ                          '), \
			 (1037,'МАНЧЖУ','МАНЧЖУРИЯ   ','МАНЧЖУРИЯ               ','МАНЧЖУРИЯ                             '), \
			 (1072,'МЯНСЕЛ','МЯНСЕЛЬГА   ','МЯНСЕЛЬГА               ','МЯНСЕЛЬГА                             '), \
			 (1082,'ЛИЖМА ','ЛИЖМА       ','ЛИЖМА                   ','ЛИЖМА                                 '), \
			 (1111,'ПРЕДМЕ','ПРЕДМЕДГОРСК','ПРЕДМЕДГОРСКИЙ          ','ПРЕДМЕДГОРСКИЙ                        '), \
			 (1140,'ВИЧКА ','ВИЧКА       ','ВИЧКА                   ','ВИЧКА                                 '), \
			 (1141,'ЛУМБУШ','ЛУМБУШОЗЕРО ','ЛУМБУШОЗЕРО             ','ЛУМБУШОЗЕРО                           '), \
			 (1210,'ИДЕЛЬ ','ИДЕЛЬ       ','ИДЕЛЬ                   ','ИДЕЛЬ                                 '), \
			 (1221,'КИЛЬБО','КИЛЬБО      ','КИЛЬБО                  ','КИЛЬБО                                '), \
			 (1231,'УДА   ','УДА         ','УДА                     ','УДА                                   '), \
			 (1232,'ГОРЕЛЫ','ГОРЕЛЫЙ МОСТ','ГОРЕЛЫЙ МОСТ            ','ГОРЕЛЫЙ МОСТ                          '), \
			 (1251,'РУЙГА ','РУЙГА       ','РУЙГА                   ','РУЙГА                                 '), \
			 (1252,'ВИРАНД','ВИРАНДОЗЕРО ','ВИРАНДОЗЕРО             ','ВИРАНДОЗЕРО                           '), \
			 (1271,'ВИРМА ','ВИРМА       ','ВИРМА                   ','ВИРМА                                 '), \
			 (1272,'СУХОЕ ','СУХОЕ       ','СУХОЕ                   ','СУХОЕ                                 '), \
			 (1274,'ВЫГ   ','ВЫГ         ','ВЫГ                     ','ВЫГ                                   '), \
			 (1299,'БЕЛОМО','БЕЛОМОРСК-НЕ','БЕЛОМОРСК-НЕЧ           ','БЕЛОМОРСК-НЕЧ                         '), \
			 (1301,'ЗАЛИВЫ','ЗАЛИВЫ      ','ЗАЛИВЫ                  ','ЗАЛИВЫ                                '), \
			 (1316,'БЕЛОМО','БЕЛОМОРСК-ВЫ','БЕЛОМОРСК-ВЫГ           ','БЕЛОМОРСК-ВЫГ                         '), \
			 (1317,'БЕЛОМ-','БЕЛОМ-БП 791','БЕЛОМ-БП 791 КМ         ','БЕЛОМ-БП 791 КМ                       '), \
			 (1320,'КЕМЬ  ','КЕМЬ        ','КЕМЬ                    ','КЕМЬ                                  '), \
			 (1352,'СИГ   ','СИГ         ','СИГ                     ','СИГ                                   '), \
			 (1356,'УНДУСА','УНДУСА      ','УНДУСА                  ','УНДУСА                                '), \
			 (1380,'ЛОУХИ ','ЛОУХИ       ','ЛОУХИ                   ','ЛОУХИ                                 '), \
			 (1421,'ГАНГОС','ГАНГОС      ','ГАНГОС                  ','ГАНГОС                                '), \
			 (1430,'ЧУПА  ','ЧУПА        ','ЧУПА                    ','ЧУПА                                  '), \
			 (1437,'КОВДА ','КОВДА       ','КОВДА                   ','КОВДА                                 '), \
			 (1438,'КАРЕЛЬ','КАРЕЛЬСКИЙ  ','КАРЕЛЬСКИЙ              ','КАРЕЛЬСКИЙ                            '), \
			 (1439,'УЗКИЙ ','УЗКИЙ       ','УЗКИЙ                   ','УЗКИЙ                                 '), \
			 (1451,'КИРКИ ','КИРКИ       ','КИРКИ                   ','КИРКИ                                 '), \
			 (1454,'ВУД-ОЗ','ВУД-ОЗЕРО   ','ВУД-ОЗЕРО               ','ВУД-ОЗЕРО                             '), \
			 (1457,'БУДАСС','БУДАССИ     ','БУДАССИ                 ','БУДАССИ                               '), \
			 (1462,'ТОВАНД','ТОВАНД      ','ТОВАНД                  ','ТОВАНД                                '), \
			 (1464,'КАПРАЕ','КАПРАЕВО    ','КАПРАЕВО                ','КАПРАЕВО                              '), \
			 (1482,'ПРОЛИВ','ПРОЛИВЫ     ','ПРОЛИВЫ                 ','ПРОЛИВЫ                               '), \
			 (1493,'ПЛЕСОЗ','ПЛЕСОЗЕРО   ','ПЛЕСОЗЕРО               ','ПЛЕСОЗЕРО                             '), \
			 (1511,'ЧЕРВАС','ЧЕРВАС      ','ЧЕРВАС                  ','ЧЕРВАС                                '), \
			 (1512,'ПАСМА ','ПАСМА       ','ПАСМА                   ','ПАСМА                                 '), \
			 (1591,'АЙКУВЕ','АЙКУВЕН     ','АЙКУВЕН                 ','АЙКУВЕН                               '), \
			 (1592,'ЮКСПОР','ЮКСПОРИОК   ','ЮКСПОРИОК               ','ЮКСПОРИОК                             '), \
			 (1611,'АПАТИТ','АПАТИТЫ-ТИТА','АПАТИТЫ-ТИТАН           ','АПАТИТЫ-ТИТАН                         '), \
			 (1617,'АПАТИТ','АПАТИТЫ-БП 1','АПАТИТЫ-БП 1268 КМ      ','АПАТИТЫ-БП 1268 КМ                    '), \
			 (1622,'РУДНЫЙ','РУДНЫЙ      ','РУДНЫЙ                  ','РУДНЫЙ                                '), \
			 (1624,'ЯГЕЛЬН','ЯГЕЛЬНЫЙ БОР','ЯГЕЛЬНЫЙ БОР            ','ЯГЕЛЬНЫЙ БОР                          '), \
			 (1674,'КИЦА  ','КИЦА        ','КИЦА                    ','КИЦА                                  '), \
			 (1700,'КОЛА  ','КОЛА        ','КОЛА                    ','КОЛА                                  '), \
			 (1701,'ПОСТ 9','ПОСТ 9 КМ   ','ПОСТ 9 КМ               ','ПОСТ 9 КМ                             '), \
			 (1711,'ПОСТ-Т','ПОСТ-ТУЛОМА ','ПОСТ-ТУЛОМА             ','ПОСТ-ТУЛОМА                           '), \
			 (1730,'ПЯЙВЕ ','ПЯЙВЕ       ','ПЯЙВЕ                   ','ПЯЙВЕ                                 '), \
			 (1791,'СЕМУЖН','СЕМУЖНАЯ    ','СЕМУЖНАЯ                ','СЕМУЖНАЯ                              '), \
			 (1845,'МУРМАН','МУРМАНСК-КОМ','МУРМАНСК-КОМ-МУР        ','МУРМАНСК-КОМ-МУР                      '), \
			 (1846,'МУРМАН','МУРМАНСК-КОЛ','МУРМАНСК-КОЛА           ','МУРМАНСК-КОЛА                         '), \
			 (1861,'ПРОМЫШ','ПРОМЫШЛЕННАЯ','ПРОМЫШЛЕННАЯ            ','ПРОМЫШЛЕННАЯ                          '), \
			 (1870,'КОМСОМ','КОМСОМОЛЬСК-','КОМСОМОЛЬСК-МУРМАНСКИЙ-Э','КОМСОМОЛЬСК-МУРМАНСКИЙ-ЭКСПОРТ        '), \
			 (2003,'ПАЛЬЦЕ','ПАЛЬЦЕВО    ','ПАЛЬЦЕВО                ','ПАЛЬЦЕВО                              '), \
			 (2006,'ГВАРДЕ','ГВАРДЕЙСКОЕ ','ГВАРДЕЙСКОЕ             ','ГВАРДЕЙСКОЕ                           '), \
			 (2007,'ПИОНЕР','ПИОНЕРЛАГЕРЬ','ПИОНЕРЛАГЕРЬ            ','ПИОНЕРЛАГЕРЬ                          '), \
			 (2012,'ВЫБОРГ','ВЫБОРГ-ПРИГ ','ВЫБОРГ-ПРИГ             ','ВЫБОРГ-ПРИГ                           '), \
			 (2013,'ВЫБОРГ','ВЫБОРГ-ПИХ  ','ВЫБОРГ-ПИХ              ','ВЫБОРГ-ПИХ                            '), \
			 (2014,'ВЫБОРГ','ВЫБОРГ-ВЕРХ ','ВЫБОРГ-ВЕРХ             ','ВЫБОРГ-ВЕРХ                           '), \
			 (2031,'БОР   ','БОР         ','БОР                     ','БОР                                   '), \
			 (2052,'МАТРОС','МАТРОСОВО   ','МАТРОСОВО               ','МАТРОСОВО                             '), \
			 (2053,'СОКОЛИ','СОКОЛИНСКОЕ ','СОКОЛИНСКОЕ             ','СОКОЛИНСКОЕ                           '), \
			 (2062,'ЩЕРБАК','ЩЕРБАКОВО   ','ЩЕРБАКОВО               ','ЩЕРБАКОВО                             '), \
			 (2091,'ЛЕБЕДЕ','ЛЕБЕДЕВКА   ','ЛЕБЕДЕВКА               ','ЛЕБЕДЕВКА                             '), \
			 (2093,'ЛАЗОРЕ','ЛАЗОРЕВКА   ','ЛАЗОРЕВКА               ','ЛАЗОРЕВКА                             '), \
			 (2100,'ТАММИС','ТАММИСУО    ','ТАММИСУО                ','ТАММИСУО                              '), \
			 (2111,'ОСИНОВ','ОСИНОВКА    ','ОСИНОВКА                ','ОСИНОВКА                              '), \
			 (2112,'ПЕРОВО','ПЕРОВО      ','ПЕРОВО                  ','ПЕРОВО                                '), \
			 (2113,'КАРХУС','КАРХУСУО    ','КАРХУСУО                ','КАРХУСУО                              '), \
			 (2131,'КРАВЦО','КРАВЦОВО    ','КРАВЦОВО                ','КРАВЦОВО                              '), \
			 (2161,'ХАННИЛ','ХАННИЛА     ','ХАННИЛА                 ','ХАННИЛА                               '), \
			 (2164,'КУОРЕК','КУОРЕКОСКИ  ','КУОРЕКОСКИ              ','КУОРЕКОСКИ                            '), \
			 (2171,'ВАЙНИК','ВАЙНИККАЛА  ','ВАЙНИККАЛА              ','ВАЙНИККАЛА                            '), \
			 (2172,'ЛЕНИЯР','ЛЕНИЯРВИ    ','ЛЕНИЯРВИ                ','ЛЕНИЯРВИ                              '), \
			 (2173,'КАМЕНН','КАМЕННОГОРСК','КАМЕННОГОРСК I          ','КАМЕННОГОРСК I                        '), \
			 (2175,'ОЗЕРСК','ОЗЕРСКОЕ    ','ОЗЕРСКОЕ                ','ОЗЕРСКОЕ                              '), \
			 (2177,'ДРУЖНО','ДРУЖНОЕ     ','ДРУЖНОЕ                 ','ДРУЖНОЕ                               '), \
			 (2181,'КИВИОЯ','КИВИОЯ      ','КИВИОЯ                  ','КИВИОЯ                                '), \
			 (2201,'ИМАТРА','ИМАТРА      ','ИМАТРА                  ','ИМАТРА                                '), \
			 (2210,'ПРУДЫ ','ПРУДЫ       ','ПРУДЫ                   ','ПРУДЫ                                 '), \
			 (2220,'КРАСНЫ','КРАСНЫЙ СОКО','КРАСНЫЙ СОКОЛ           ','КРАСНЫЙ СОКОЛ                         '), \
			 (2232,'ХАКОЛА','ХАКОЛАХТИ   ','ХАКОЛАХТИ               ','ХАКОЛАХТИ                             '), \
			 (2234,'ПУКИНН','ПУКИННИЕМИ  ','ПУКИННИЕМИ              ','ПУКИННИЕМИ                            '), \
			 (2241,'ХАУККА','ХАУККАВААРА ','ХАУККАВААРА             ','ХАУККАВААРА                           '), \
			 (2242,'АЛХО  ','АЛХО        ','АЛХО                    ','АЛХО                                  '), \
			 (2261,'ЛОСЕВО','ЛОСЕВО      ','ЛОСЕВО                  ','ЛОСЕВО                                '), \
			 (2265,'ЛОСЕВО','ЛОСЕВО I    ','ЛОСЕВО I                ','ЛОСЕВО I                              '), \
			 (2271,'СУХОДО','СУХОДОЛЬЕ   ','СУХОДОЛЬЕ               ','СУХОДОЛЬЕ                             '), \
			 (2291,'СИНЕВО','СИНЕВО      ','СИНЕВО                  ','СИНЕВО                                '), \
			 (2301,'КАПЕАС','КАПЕАСАЛМИ  ','КАПЕАСАЛМИ              ','КАПЕАСАЛМИ                            '), \
			 (2321,'АККАХА','АККАХАРЬЮ   ','АККАХАРЬЮ               ','АККАХАРЬЮ                             '), \
			 (2322,'ИХАЛА ','ИХАЛА       ','ИХАЛА                   ','ИХАЛА                                 '), \
			 (2324,'СОРЙО ','СОРЙО       ','СОРЙО                   ','СОРЙО                                 '), \
			 (2362,'КУММУН','КУММУНЙОКИ  ','КУММУНЙОКИ              ','КУММУНЙОКИ                            '), \
			 (2363,'НИВА  ','НИВА        ','НИВА                    ','НИВА                                  '), \
			 (2366,'ТУОКСЛ','ТУОКСЛАХТИ  ','ТУОКСЛАХТИ              ','ТУОКСЛАХТИ                            '), \
			 (2367,'ЛАХДЕН','ЛАХДЕНПОХЬЯ ','ЛАХДЕНПОХЬЯ             ','ЛАХДЕНПОХЬЯ                           '), \
			 (2381,'РЮТТЮ ','РЮТТЮ       ','РЮТТЮ                   ','РЮТТЮ                                 '), \
			 (2411,'ПЯЛЬКЬ','ПЯЛЬКЬЯРВИ  ','ПЯЛЬКЬЯРВИ              ','ПЯЛЬКЬЯРВИ                            '), \
			 (2412,'ПЯЛЬКС','ПЯЛЬКСААРИ  ','ПЯЛЬКСААРИ              ','ПЯЛЬКСААРИ                            '), \
			 (2413,'НИЙРАЛ','НИЙРАЛА     ','НИЙРАЛА                 ','НИЙРАЛА                               '), \
			 (2442,'ТУУКСА','ТУУКСА      ','ТУУКСА                  ','ТУУКСА                                '), \
			 (2443,'ИЛЬИНС','ИЛЬИНСКАЯ   ','ИЛЬИНСКАЯ               ','ИЛЬИНСКАЯ                             '), \
			 (2462,'КУРКУН','КУРКУНКУЛА  ','КУРКУНКУЛА              ','КУРКУНКУЛА                            '), \
			 (2471,'САТУЛИ','САТУЛИ      ','САТУЛИ                  ','САТУЛИ                                '), \
			 (2472,'УУКСУ ','УУКСУ II    ','УУКСУ II                ','УУКСУ II                              '), \
			 (2473,'ИЛЯ-УУ','ИЛЯ-УУКСУ   ','ИЛЯ-УУКСУ               ','ИЛЯ-УУКСУ                             '), \
			 (2481,'КОЙРИН','КОЙРИНОЯ    ','КОЙРИНОЯ                ','КОЙРИНОЯ                              '), \
			 (2482,'КИТЕЛЯ','КИТЕЛЯ      ','КИТЕЛЯ                  ','КИТЕЛЯ                                '), \
			 (2492,'ВЯЛИМЯ','ВЯЛИМЯКИ    ','ВЯЛИМЯКИ                ','ВЯЛИМЯКИ                              '), \
			 (2510,'ХАРЛУ ','ХАРЛУ       ','ХАРЛУ                   ','ХАРЛУ                                 '), \
			 (2511,'ХЯМЕКО','ХЯМЕКОСКИ   ','ХЯМЕКОСКИ               ','ХЯМЕКОСКИ                             '), \
			 (2513,'АЛАЛАМ','АЛАЛАМПИ    ','АЛАЛАМПИ                ','АЛАЛАМПИ                              '), \
			 (2542,'СЯНЬГА','СЯНЬГА      ','СЯНЬГА                  ','СЯНЬГА                                '), \
			 (2571,'ЗАСТАВ','ЗАСТАВА     ','ЗАСТАВА                 ','ЗАСТАВА                               '), \
			 (2575,'ВЕРККО','ВЕРККО      ','ВЕРККО                  ','ВЕРККО                                '), \
			 (2591,'НЯЯТЯО','НЯЯТЯОЯ     ','НЯЯТЯОЯ                 ','НЯЯТЯОЯ                               '), \
			 (2621,'СУЙСТА','СУЙСТАМО    ','СУЙСТАМО                ','СУЙСТАМО                              '), \
			 (2622,'АЛАТТУ','АЛАТТУ      ','АЛАТТУ                  ','АЛАТТУ                                '), \
			 (2690,'ПЕТРОГ','ПЕТРОГРАНИТ ','ПЕТРОГРАНИТ             ','ПЕТРОГРАНИТ                           '), \
			 (2692,'РУГОЛА','РУГОЛАМБИ   ','РУГОЛАМБИ               ','РУГОЛАМБИ                             '), \
			 (2703,'КАНГАС','КАНГАС      ','КАНГАС                  ','КАНГАС                                '), \
			 (2710,'ГИМОЛЬ','ГИМОЛЬСКАЯ  ','ГИМОЛЬСКАЯ              ','ГИМОЛЬСКАЯ                            '), \
			 (2741,'ВОЛОМА','ВОЛОМА      ','ВОЛОМА                  ','ВОЛОМА                                '), \
			 (2751,'СЕЛЬГА','СЕЛЬГА      ','СЕЛЬГА                  ','СЕЛЬГА                                '), \
			 (2752,'СОНОЗЕ','СОНОЗЕРО    ','СОНОЗЕРО                ','СОНОЗЕРО                              '), \
			 (2761,'МУЕЗЕР','МУЕЗЕРКА    ','МУЕЗЕРКА                ','МУЕЗЕРКА                              '), \
			 (2772,'ХИЖОЗЕ','ХИЖОЗЕРО    ','ХИЖОЗЕРО                ','ХИЖОЗЕРО                              '), \
			 (2773,'ЛЕДМОЗ','ЛЕДМОЗЕРО II','ЛЕДМОЗЕРО II            ','ЛЕДМОЗЕРО II                          '), \
			 (2774,'ПЕРТОЗ','ПЕРТОЗЕРО   ','ПЕРТОЗЕРО               ','ПЕРТОЗЕРО                             '), \
			 (2801,'ВАРТИУ','ВАРТИУС     ','ВАРТИУС                 ','ВАРТИУС                               '), \
			 (3009,'ПСМ-УС','ПСМ-УСЛ     ','ПСМ-УСЛ                 ','ПСМ-УСЛ                               '), \
			 (3012,'ГРИБНО','ГРИБНОЕ     ','ГРИБНОЕ                 ','ГРИБНОЕ                               '), \
			 (3015,'СПБ-С-','СПБ-С-М-В-НС','СПБ-С-М-В-НСУ 5         ','СПБ-С-М-В-НСУ 5                       '), \
			 (3016,'СПБ-С-','СПБ-С-М-В-НС','СПБ-С-М-В-НСУ 10        ','СПБ-С-М-В-НСУ 10                      '), \
			 (3017,'СПБ-С-','СПБ-С-М-ГЛ  ','СПБ-С-М-ГЛ              ','СПБ-С-М-ГЛ                            '), \
			 (3018,'СПБ-С-','СПБ-С-М-СПБ-','СПБ-С-М-СПБ-Т-М         ','СПБ-С-М-СПБ-Т-М                       '), \
			 (3019,'СПБ-С-','СПБ-С-М-К   ','СПБ-С-М-К               ','СПБ-С-М-К                             '), \
			 (3020,'МГА   ','МГА         ','МГА                     ','МГА                                   '), \
			 (3022,'ГОРЫ  ','ГОРЫ        ','ГОРЫ                    ','ГОРЫ                                  '), \
			 (3023,'ВОЙТОЛ','ВОЙТОЛОВКА  ','ВОЙТОЛОВКА              ','ВОЙТОЛОВКА                            '), \
			 (3024,'СПБ-С-','СПБ-С-М-Р   ','СПБ-С-М-Р               ','СПБ-С-М-Р                             '), \
			 (3025,'СПБ-С-','СПБ-С-М-СЛ  ','СПБ-С-М-СЛ              ','СПБ-С-М-СЛ                            '), \
			 (3041,'ГЕРОЙС','ГЕРОЙСКАЯ   ','ГЕРОЙСКАЯ               ','ГЕРОЙСКАЯ                             '), \
			 (3042,'ОСТРОВ','ОСТРОВКИ    ','ОСТРОВКИ                ','ОСТРОВКИ                              '), \
			 (3052,'КОЛТУШ','КОЛТУШИ     ','КОЛТУШИ                 ','КОЛТУШИ                               '), \
			 (3053,'МЯГЛОВ','МЯГЛОВО     ','МЯГЛОВО                 ','МЯГЛОВО                               '), \
			 (3060,'ПЕЛЛА ','ПЕЛЛА       ','ПЕЛЛА                   ','ПЕЛЛА                                 '), \
			 (3062,'УСТЬ-Т','УСТЬ-ТОСНЕНС','УСТЬ-ТОСНЕНСКАЯ         ','УСТЬ-ТОСНЕНСКАЯ                       '), \
			 (3080,'ИЖОРЫ ','ИЖОРЫ       ','ИЖОРЫ                   ','ИЖОРЫ                                 '), \
			 (3100,'ОБУХОВ','ОБУХОВО     ','ОБУХОВО                 ','ОБУХОВО                               '), \
			 (3120,'УШАКИ ','УШАКИ       ','УШАКИ                   ','УШАКИ                                 '), \
			 (3129,'ТОСНО-','ТОСНО-САБ-ЧН','ТОСНО-САБ-ЧН            ','ТОСНО-САБ-ЧН                          '), \
			 (3131,'ТОСНО ','ТОСНО II    ','ТОСНО II                ','ТОСНО II                              '), \
			 (3136,'АВТОЗА','АВТОЗАВОД   ','АВТОЗАВОД               ','АВТОЗАВОД                             '), \
			 (3138,'ТОСНО-','ТОСНО-УШАКИ ','ТОСНО-УШАКИ             ','ТОСНО-УШАКИ                           '), \
			 (3139,'ТОСНО-','ТОСНО-САБЛ-Ч','ТОСНО-САБЛ-Ч            ','ТОСНО-САБЛ-Ч                          '), \
			 (3141,'ТОСНО-','ТОСНО-СТЕК  ','ТОСНО-СТЕК              ','ТОСНО-СТЕК                            '), \
			 (3142,'ТОСНО-','ТОСНО-НУРМА ','ТОСНО-НУРМА             ','ТОСНО-НУРМА                           '), \
			 (3150,'ШАПКИ ','ШАПКИ       ','ШАПКИ                   ','ШАПКИ                                 '), \
			 (3152,'НУРМА ','НУРМА       ','НУРМА                   ','НУРМА                                 '), \
			 (3162,'МЕТАЛЛ','МЕТАЛЛОСТРОЙ','МЕТАЛЛОСТРОЙ            ','МЕТАЛЛОСТРОЙ                          '), \
			 (3182,'СПБ-Т-','СПБ-Т-М-СПБ-','СПБ-Т-М-СПБ-Г1          ','СПБ-Т-М-СПБ-Г1                        '), \
			 (3183,'СПБ-Т-','СПБ-Т-М-СПБ-','СПБ-Т-М-СПБ-Г2          ','СПБ-Т-М-СПБ-Г2                        '), \
			 (3184,'СПБ-Т-','СПБ-Т-М-СПБ-','СПБ-Т-М-СПБ-С-М1        ','СПБ-Т-М-СПБ-С-М1                      '), \
			 (3185,'СПБ-Т-','СПБ-Т-М-СПБ-','СПБ-Т-М-СПБ-С-М2        ','СПБ-Т-М-СПБ-С-М2                      '), \
			 (3186,'СПБ-Т-','СПБ-Т-М-СПБ-','СПБ-Т-М-СПБ-С-М3        ','СПБ-Т-М-СПБ-С-М3                      '), \
			 (3187,'СПБ-Т-','СПБ-Т-М-В   ','СПБ-Т-М-В               ','СПБ-Т-М-В                             '), \
			 (3188,'СПБ-Т-','СПБ-Т-М-ГЛ1 ','СПБ-Т-М-ГЛ1             ','СПБ-Т-М-ГЛ1                           '), \
			 (3189,'СПБ-Т-','СПБ-Т-М-ГЛ2 ','СПБ-Т-М-ГЛ2             ','СПБ-Т-М-ГЛ2                           '), \
			 (3212,'КНЯЖЕЛ','КНЯЖЕЛИСИНО ','КНЯЖЕЛИСИНО             ','КНЯЖЕЛИСИНО                           '), \
			 (3270,'ЦАРСКО','ЦАРСКОЕ СЕЛО','ЦАРСКОЕ СЕЛО            ','ЦАРСКОЕ СЕЛО                          '), \
			 (3271,'ДЕТСКО','ДЕТСКОСЕЛЬСК','ДЕТСКОСЕЛЬСКАЯ          ','ДЕТСКОСЕЛЬСКАЯ                        '), \
			 (3291,'ШУШАРЫ','ШУШАРЫ-ЦАР.С','ШУШАРЫ-ЦАР.С            ','ШУШАРЫ-ЦАР.С                          '), \
			 (3292,'ШУШАРЫ','ШУШАРЫ-КУПЧ ','ШУШАРЫ-КУПЧ             ','ШУШАРЫ-КУПЧ                           '), \
			 (3293,'ШУШАРЫ','ШУШАРЫ-СРЕДН','ШУШАРЫ-СРЕДН            ','ШУШАРЫ-СРЕДН                          '), \
			 (3294,'ШУШАРЫ','ШУШАРЫ-С-П-П','ШУШАРЫ-С-П-П-ВИТ        ','ШУШАРЫ-С-П-П-ВИТ                      '), \
			 (3298,'ШУШАРЫ','ШУШАРЫ-ЧЕТ  ','ШУШАРЫ-ЧЕТ              ','ШУШАРЫ-ЧЕТ                            '), \
			 (3305,'БОРОВА','БОРОВАЯ     ','БОРОВАЯ                 ','БОРОВАЯ                               '), \
			 (3382,'САБОРЫ','САБОРЫ      ','САБОРЫ                  ','САБОРЫ                                '), \
			 (3402,'ГАТЧИН','ГАТЧИНА ВАРШ','ГАТЧИНА ВАРШ П.Б        ','ГАТЧИНА ВАРШ П.Б                      '), \
			 (3403,'ТАТЬЯН','ТАТЬЯНИНО   ','ТАТЬЯНИНО               ','ТАТЬЯНИНО                             '), \
			 (3404,'МОЗИНО','МОЗИНО      ','МОЗИНО                  ','МОЗИНО                                '), \
			 (3411,'МАРИЕН','МАРИЕНБУРГ  ','МАРИЕНБУРГ              ','МАРИЕНБУРГ                            '), \
			 (3413,'ГАТЧИН','ГАТЧИНА-Т-БА','ГАТЧИНА-Т-БАЛ-ФР        ','ГАТЧИНА-Т-БАЛ-ФР                      '), \
			 (3415,'ГАТЧИН','ГАТЧИНА-Т-БА','ГАТЧИНА-Т-БАЛ-ВОЙ       ','ГАТЧИНА-Т-БАЛ-ВОЙ                     '), \
			 (3416,'ГАТЧИН','ГАТЧИНА-Т-Б-','ГАТЧИНА-Т-Б-ГАТ-ВАР-П-Б ','ГАТЧИНА-Т-Б-ГАТ-ВАР-П-Б               '), \
			 (3417,'ГАТЧИН','ГАТЧИНА-Т-Б-','ГАТЧИНА-Т-Б-ГАТ-ВАР-П-А ','ГАТЧИНА-Т-Б-ГАТ-ВАР-П-А               '), \
			 (3420,'ТАЙЦЫ ','ТАЙЦЫ       ','ТАЙЦЫ                   ','ТАЙЦЫ                                 '), \
			 (3471,'КОНДАК','КОНДАКОПШИНО','КОНДАКОПШИНО            ','КОНДАКОПШИНО                          '), \
			 (3472,'ЛЕСНОЕ','ЛЕСНОЕ      ','ЛЕСНОЕ                  ','ЛЕСНОЕ                                '), \
			 (3531,'ЭЛЕКТР','ЭЛЕКТРОДЕПО ','ЭЛЕКТРОДЕПО             ','ЭЛЕКТРОДЕПО                           '), \
			 (3613,'ПРОБА ','ПРОБА       ','ПРОБА                   ','ПРОБА                                 '), \
			 (3622,'РАХЬЯ ','РАХЬЯ       ','РАХЬЯ                   ','РАХЬЯ                                 '), \
			 (3641,'РАДЧЕН','РАДЧЕНКО    ','РАДЧЕНКО                ','РАДЧЕНКО                              '), \
			 (3651,'САДЫ  ','САДЫ        ','САДЫ                    ','САДЫ                                  '), \
			 (3652,'ЧЕРНАЯ','ЧЕРНАЯ РЕЧКА','ЧЕРНАЯ РЕЧКА            ','ЧЕРНАЯ РЕЧКА                          '), \
			 (3673,'КОВАЛЕ','КОВАЛЕВО    ','КОВАЛЕВО                ','КОВАЛЕВО                              '), \
			 (3770,'ПЕРИ  ','ПЕРИ        ','ПЕРИ                    ','ПЕРИ                                  '), \
			 (3772,'КАВГОЛ','КАВГОЛОВО   ','КАВГОЛОВО               ','КАВГОЛОВО                             '), \
			 (3801,'ЛАВРИК','ЛАВРИКИ     ','ЛАВРИКИ                 ','ЛАВРИКИ                               '), \
			 (3804,'ДЕПО Р','ДЕПО РУЧЬИ  ','ДЕПО РУЧЬИ              ','ДЕПО РУЧЬИ                            '), \
			 (3810,'РУЧЬИ ','РУЧЬИ       ','РУЧЬИ                   ','РУЧЬИ                                 '), \
			 (3819,'С-ПЕТЕ','С-ПЕТЕРБУРГ-','С-ПЕТЕРБУРГ-ФИНЛ-ЧЕТ    ','С-ПЕТЕРБУРГ-ФИНЛ-ЧЕТ                  '), \
			 (3822,'СПБ-ФИ','СПБ-ФИН-ЛАН ','СПБ-ФИН-ЛАН             ','СПБ-ФИН-ЛАН                           '), \
			 (3823,'СПБ-ФИ','СПБ-ФИН-КУШ ','СПБ-ФИН-КУШ             ','СПБ-ФИН-КУШ                           '), \
			 (3830,'ПАРНАС','ПАРНАС      ','ПАРНАС                  ','ПАРНАС                                '), \
			 (3841,'ОЗЕРКИ','ОЗЕРКИ      ','ОЗЕРКИ                  ','ОЗЕРКИ                                '), \
			 (3881,'ПЕСОЧН','ПЕСОЧНАЯ    ','ПЕСОЧНАЯ                ','ПЕСОЧНАЯ                              '), \
			 (6150,'ТВЕРЬ ','ТВЕРЬ       ','ТВЕРЬ                   ','ТВЕРЬ                                 ') \
		 " )
	}
  def " (ARRAY) the same station name for fields of different lengths"() {
    expect:
    title12.indexOf(title6) == 0
    title24.indexOf(title12) == 0
    title38.indexOf(title24) == 0

    where:
    title6 <<  ['ТВЕРЬ ', 'ПЕСОЧН']
    title12 << ['ТВЕРЬ       ', 'ПЕСОЧНАЯ    ']
    title24 << ['ТВЕРЬ                   ', 'ПЕСОЧНАЯ                ']
    title38 << ['ТВЕРЬ                                 ', 'ПЕСОЧНАЯ                              ']
  }

  def " (SQL) the same station name for fields of different lengths"() {
    expect:
    title12.indexOf(title6) == 0
    title24.indexOf(title12) == 0
    title38.indexOf(title24) == 0

    where:
    [_, title6, title12, title24, title38 ] << sql.rows("select * from STATIONS")
  }
}

