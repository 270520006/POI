# POI-EasyExcel
ELK已经学习完毕，目前考虑将最近所学的ELK整合Cloud结合MQ和EasyExcel
做一个文件管理项目，或报表项目。目前整合想法是，L同步数据库到ES上，
发生增删改，同时调用L，然后有数据优先找ES，没有就Redis缓存，再没有再走mysql。
鉴于ES没有事务功能，所以这里使用MQ为其提供事务功能。
为了防止ES突然崩溃而导致数据库和ES双写不一致，
这里我准备使用mysql的binlog来进行同步，
读取mysql的binlog日志,然后把读取的信息转为MQ，
然后编一个MQ消费程序不断消费MQ,每消费完―条消息，将消息写入到ES中。

just study

记录POI和EasyExcel的学习过程

使用POI读写 zsp 2021/4/6 20:44

POI判断取值类型并读取 zsp 2021/4/6 23:54

POI判断取值类型并读取 zsp 2021/4/6 23:54

POI区分类型并且读取' zsp 2021/4/6 23:56

POI获取公式并且输出公式值 zsp Yesterday 1:08

公式获取并且获取公式所得值 zsp Yesterday 1:10

easyExcel写入完毕，下午完成读取，并且结合数据库 zsp Yesterday 14:04

easyExcel读取写入皆学完了 zsp Yesterday 20:13

用mp生成代码，下一部将EasyExcel结合进框架 zsp Today 1:20

实现了数据库生成Excel zsp Today 15:21

实现了数据库写出到Excel和Excel写入到数据库 zsp 2 minutes ago