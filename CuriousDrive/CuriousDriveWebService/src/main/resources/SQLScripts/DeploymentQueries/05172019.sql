-- WORKING ON TAG

-- SELECT * FROM tag_detail;

-- ALTER TABLE tag_detail
-- ADD CONSTRAINT FK_TagDetailTag
-- FOREIGN KEY (TAG_ID) REFERENCES tag(TAG_ID);

-- ALTER TABLE tag_detail
-- ADD CONSTRAINT FK_TagDetailUser
-- FOREIGN KEY (TAGGED_USER_ID) REFERENCES user(USER_ID);

-- DELETE from tag_detail where TAG_ID not in (SELECT TAG_ID from tag)

-- -----------------------------------------------------------------------------------


-- WORKING ON TAG

-- SELECT * FROM tag;

-- ALTER TABLE tag
-- ADD CONSTRAINT FK_TagUser
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);

-- DELETE from tag where USER_ID not in (select USER_ID from user)

-- DELETE FROM tag where USER_GROUP_TYPE_VALUE = 'year';

-- ALTER TABLE tag ADD COLUMN USER_GROUP_ID INT(11) NULL AFTER USER_GROUP_VALUE;

-- UPDATE TAG set USER_GROUP_ID = USER_GROUP_VALUE;

-- ALTER TABLE tag DROP COLUMN USER_GROUP_VALUE;

-- ALTER TABLE tag ADD COLUMN QUESTION_ID INT(11) NULL AFTER USER_GROUP_ID;

-- ALTER TABLE tag ADD COLUMN ANNOUNCEMENT_ID INT(11) NULL AFTER QUESTION_ID;

-- UPDATE tag set QUESTION_ID = SUBSYSTEM_REFERENCE_ID where SUBSYSTEM_VALUE = 'QUES';

-- UPDATE tag set ANNOUNCEMENT_ID = SUBSYSTEM_REFERENCE_ID where SUBSYSTEM_VALUE = 'ANNC'

-- ALTER TABLE tag
-- ADD CONSTRAINT FK_TagQuestion
-- FOREIGN KEY (QUESTION_ID) REFERENCES question(QUESTION_ID);

-- DELETE FROM tag WHERE QUESTION_ID IS NOT NULL AND QUESTION_ID NOT IN (SELECT QUESTION_ID FROM question);

-- ALTER TABLE tag
-- ADD CONSTRAINT FK_TagAnnouncement
-- FOREIGN KEY (ANNOUNCEMENT_ID) REFERENCES announcement(ANNOUNCEMENT_ID);

-- DELETE FROM tag WHERE ANNOUNCEMENT_ID IS NOT NULL AND ANNOUNCEMENT_ID NOT IN (SELECT ANNOUNCEMENT_ID FROM announcement);

-- DROPPING OLD COLUMNS
-- ALTER TABLE tag DROP COLUMN SUBSYSTEM_ID;

-- ALTER TABLE tag DROP COLUMN SUBSYSTEM_VALUE;

-- ALTER TABLE tag DROP COLUMN SUBSYSTEM_REFERENCE_ID;



-- -----------------------------------------------------------------------------------

-- WORKING ON USER ROLE

-- SELECT * FROM user_role;

-- SELECT * FROM ROLE

-- DROPPING OLD COLUMNS
-- ALTER TABLE user_role DROP COLUMN USER_GROUP_ID;

-- ALTER TABLE user_role DROP COLUMN USER_GROUP_VALUE;

-- ALTER TABLE user_role DROP COLUMN ROLE_VALUE;

-- ALTER TABLE user_role
-- ADD CONSTRAINT FK_UserRoleRole
-- FOREIGN KEY (ROLE_ID) REFERENCES role(ROLE_ID);

-- ALTER TABLE user_role
-- ADD CONSTRAINT FK_UserRoleUser
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);

-- DELETE from user_role where USER_ID not in (select USER_ID from user);

-- UPDATE user_role SET ROLE_ID = 5 WHERE ROLE_ID = -1  LIMIT 15

-- -----------------------------------------------------------------------------------

-- WORKING ON USER GROUP DETAIL

-- SELECT * FROM user_group_detail;

-- ALTER TABLE user_group_detail
-- ADD CONSTRAINT FK_UserGroupDetailUserGroup
-- FOREIGN KEY (USER_GROUP_ID) REFERENCES user_group(USER_GROUP_ID);

-- ALTER TABLE user_group_detail
-- ADD CONSTRAINT FK_UserGroupDetailUser
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);

-- -----------------------------------------------------------------------------------

-- WORKING ON USER GROUP

-- SELECT * FROM user_group;

-- -----------------------------------------------------------------------------------

-- WORKING ON USER

-- SELECT * FROM user;

-- -----------------------------------------------------------------------------------

-- WORKING ON TAG

-- DROP TABLE thread;

-- -----------------------------------------------------------------------------------


-- WORKING ON ROLE

-- SELECT * FROM role;

-- -----------------------------------------------------------------------------------

-- WORKING ON QESTION VIEW

-- SELECT * FROM question_view;

-- delete from question_view;

-- ALTER TABLE question_class ADD COLUMN USER_ID INT(11) NULL AFTER QUESTION_ID;

-- ALTER TABLE question_view
-- ADD CONSTRAINT FK_QuestionViewQuestion
-- FOREIGN KEY (QUESTION_ID) REFERENCES question(QUESTION_ID);

-- ALTER TABLE question_view
-- ADD CONSTRAINT FK_QuestionViewUser
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);

-- UPDATE question_view SET USER_ID = CREATED_BY

-- -----------------------------------------------------------------------------------

-- WORKING ON QESTION CLASS

-- SELECT * FROM question_class;

-- ALTER TABLE question_class ADD COLUMN USER_ID INT(11) NULL AFTER QUESTION_ID;

-- ALTER TABLE question_class
-- ADD CONSTRAINT FK_QuestionClassQuestion
-- FOREIGN KEY (QUESTION_ID) REFERENCES question(QUESTION_ID);

-- ALTER TABLE question_class
-- ADD CONSTRAINT FK_QuestionClassClass
-- FOREIGN KEY (CLASS_ID) REFERENCES class(CLASS_ID);

-- UPDATE question_answer SET USER_ID = CREATED_BY

-- -----------------------------------------------------------------------------------

-- WORKING ON QESTION ANSWER

-- SELECT * FROM question_answer;

-- ALTER TABLE question DROP COLUMN THREAD_ID;

-- ALTER TABLE question DROP COLUMN IS_VALID;

-- ALTER TABLE question_answer ADD COLUMN USER_ID INT(11) NULL AFTER QUESTION_ID;

-- ALTER TABLE question_answer
-- ADD CONSTRAINT FK_QuestionAnswerUser
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);

-- ALTER TABLE question_answer
-- ADD CONSTRAINT FK_QuestionAnswerQuestion
-- FOREIGN KEY (QUESTION_ID) REFERENCES question(QUESTION_ID);

-- UPDATE question_answer SET USER_ID = CREATED_BY

-- -----------------------------------------------------------------------------------

-- WORKING ON QESTION 

-- SELECT * FROM question;

-- ALTER TABLE question DROP COLUMN THREAD_ID;

-- ALTER TABLE question DROP COLUMN IS_VALID;

-- ALTER TABLE question ADD COLUMN USER_ID INT(11) NULL AFTER QUESTION_ID;

-- ALTER TABLE question
-- ADD CONSTRAINT FK_QuestionUser
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);

-- UPDATE question Q
-- INNER JOIN user U ON U.USER_ID = Q.CREATED_BY
-- SET Q.USER_ID = U.USER_ID;

-- SELECT * FROM question WHERE USER_ID IS NULL

-- -----------------------------------------------------------------------------------

-- DROPPING TABLES 

-- DROP TABLE question_answer_history;

-- DROP TABLE question_favorite;

-- DROP TABLE question_valid;

-- DROP TABLE question_history;

-- DROP TABLE report_abuse;
-- -----------------------------------------------------------------------------------

-- WORKING ON POINT TABLE

-- SELECT * FROM post_vote;

-- ALTER TABLE post_vote ADD COLUMN QUESTION_ANSWER_ID INT(11) NULL AFTER QUESTION_ID;

-- ALTER TABLE post_vote
-- ADD CONSTRAINT FK_PostVoteQuestion
-- FOREIGN KEY (QUESTION_ID) REFERENCES question(QUESTION_ID);

-- ALTER TABLE post_vote
-- ADD CONSTRAINT FK_PostVoteQuestionAnswer
-- FOREIGN KEY (QUESTION_ANSWER_ID) REFERENCES question_answer(QUESTION_ANSWER_ID);

-- ALTER TABLE post_vote DROP COLUMN SUBSYSTEM_REFERENCE_ID;

-- -----------------------------------------------------------------------------------

-- WORKING ON POINT TABLE

-- DELETE FROM point;

-- ALTER TABLE point ADD COLUMN QUESTION_ANSWER_ID INT(11) NULL AFTER QUESTION_ID;

-- ALTER TABLE point
-- ADD CONSTRAINT FK_PointUser
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);

-- ALTER TABLE notification
-- ADD CONSTRAINT FK_ToUserUser
-- FOREIGN KEY (TO_USER_ID) REFERENCES user(USER_ID);

-- -----------------------------------------------------------------------------------

-- WORKING ON NOTIFICATION TABLE

-- SELECT * FROM notification;

-- ALTER TABLE notification
-- ADD CONSTRAINT FK_FromUserUser
-- FOREIGN KEY (FROM_USER_ID) REFERENCES user(USER_ID);

-- ALTER TABLE notification
-- ADD CONSTRAINT FK_ToUserUser
-- FOREIGN KEY (TO_USER_ID) REFERENCES user(USER_ID);

-- -----------------------------------------------------------------------------------

-- WORKING ON MESSAGE TABLE

-- SELECT * FROM message

-- -----------------------------------------------------------------------------------

-- WORKING ON LEVEL TABLE

-- DROP TABLE LEVEL;

-- -----------------------------------------------------------------------------------

-- WORKING ON FEEDBACK TABLE

-- SELECT * FROM feedback;

-- DROPPING OLD COLUMNS
-- ALTER TABLE feedback DROP COLUMN IS_VERIFIED;

-- ALTER TABLE feedback DROP COLUMN VALUE;

-- ALTER TABLE feedback
-- ADD CONSTRAINT FK_UserFeedback
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);


-- -----------------------------------------------------------------------------------

-- WORKING ON CODE VALUE TABLE

-- SELECT * FROM code_value;

-- ALTER TABLE code_value
-- ADD CONSTRAINT FK_CodeCodeValue
-- FOREIGN KEY (CODE_ID) REFERENCES code(CODE_ID)

-- -----------------------------------------------------------------------------------

-- WORKING ON COMMENT TABLE

-- ADDING THE COLUMNS
-- ALTER TABLE comment ADD COLUMN QUESTION_ID INT(11) NULL AFTER USER_ID;

-- ALTER TABLE comment ADD COLUMN ANNOUNCEMENT_ID INT(11) NULL AFTER QUESTION_ID;

-- MIGRATING DATA INTO NEW COLUMNS
-- UPDATE comment SET ANNOUNCEMENT_ID = SUBSYSTEM_REFERENCE_ID WHERE SUBSYSTEM_VALUE = 'ANNC';

-- UPDATE comment SET QUESTION_ID = SUBSYSTEM_REFERENCE_ID WHERE SUBSYSTEM_VALUE = 'QUES';

-- SELECT * FROM comment;

-- DROPPING OLD COLUMNS
-- ALTER TABLE comment DROP COLUMN SUBSYSTEM_ID;

-- ALTER TABLE comment DROP COLUMN SUBSYSTEM_VALUE;

-- ALTER TABLE comment DROP COLUMN SUBSYSTEM_REFERENCE_ID;

-- ADDING FOREIGN KEYS 

-- ALTER TABLE comment
-- ADD CONSTRAINT FK_QuestionComment
-- FOREIGN KEY (QUESTION_ID) REFERENCES question(QUESTION_ID);

-- ALTER TABLE comment
-- ADD CONSTRAINT FK_AnnouncementComment
-- FOREIGN KEY (ANNOUNCEMENT_ID) REFERENCES announcement(ANNOUNCEMENT_ID);

-- ALTER TABLE comment
-- ADD CONSTRAINT FK_UserComment
-- FOREIGN KEY (USER_ID) REFERENCES user(USER_ID);


-- -----------------------------------------------------------------------------------