/* テーブルが存在する場合は削除 */
DROP TABLE IF EXISTS common_mst;

DROP TABLE IF EXISTS user_mst;

/* ユーザマスタ作成 */
CREATE TABLE user_mst(
	user_id VARCHAR(12) NOT NULL,
	password VARCHAR NOT NULL,
	user_name VARCHAR(100) NOT NULL,
	secret_id VARCHAR(7) NOT NULL,
	secret_answer VARCHAR(200) NOT NULL,
	error_password SMALLINT,
	lock BOOLEAN,
	authority SMALLINT NOT NULL DEFAULT 0,
	update_datetime DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	version SMALLINT NOT NULL DEFAULT 0,
	PRIMARY KEY(user_id)
);

/* 汎用マスタ作成 */
CREATE TABLE common_mst(
	common_id VARCHAR(7) NOT NULL,
	common_group VARCHAR(100) NOT NULL,
	common_name VARCHAR(200) NOT NULL,
	common_value1 VARCHAR(200),
	common_value2 VARCHAR(200),
	update_datetime DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	version SMALLINT NOT NULL DEFAULT 0,
	PRIMARY KEY(common_id)
);

/* ユーザマスタコメント */
COMMENT ON TABLE user_mst IS 'ユーザマスタ';

COMMENT ON COLUMN user_mst.user_id IS 'ユーザID';

COMMENT ON COLUMN user_mst.password IS 'パスワード';

COMMENT ON COLUMN user_mst.user_name IS 'ユーザ名';

COMMENT ON COLUMN user_mst.secret_id IS '秘密の質問ID';

COMMENT ON COLUMN user_mst.secret_answer IS '秘密の答え';

COMMENT ON COLUMN user_mst.error_password IS 'パスワード間違え回数';

COMMENT ON COLUMN user_mst.lock IS 'アカウントロック';

COMMENT ON COLUMN user_mst.authority IS '権限';

COMMENT ON COLUMN user_mst.update_datetime IS '更新日時';

COMMENT ON COLUMN user_mst.version IS 'バージョン';

/* 汎用マスタコメント */
COMMENT ON TABLE common_mst IS '汎用マスタ';

COMMENT ON COLUMN common_mst.common_id IS '汎用マスタID';

COMMENT ON COLUMN common_mst.common_group IS '汎用マスタグループ';

COMMENT ON COLUMN common_mst.common_name IS '汎用マスタ名';

COMMENT ON COLUMN common_mst.common_value1 IS '汎用マスタ値';

COMMENT ON COLUMN common_mst.common_value2 IS '汎用マスタ値';

COMMENT ON COLUMN common_mst.update_datetime IS '更新日時';

COMMENT ON COLUMN common_mst.version IS 'バージョン';

INSERT INTO
	user_mst(
		user_id,
		password,
		user_name,
		secret_id,
		secret_answer,
		error_password,
		lock,
		authority
	)
VALUES
	(
		'user00000001',
		'$2a$10$m5CzxWKChQWZd464NOHLueG.sgoEfMASNwRZ6pQmN.k2wkFpiAHaS',
		'test',
		'com0001',
		'$2a$10$m5CzxWKChQWZd464NOHLueG.sgoEfMASNwRZ6pQmN.k2wkFpiAHaS',
		'0',
		'FALSE',
		'0'
	);

INSERT INTO
	common_mst(
		common_id,
		common_group,
		common_name,
		common_value1,
		common_value2
	)
VALUES
	(
		'com0001',
		'secret_question',
		'秘密の質問',
		'好きな食べ物は？',
		'好きな食べ物は？'
	);

INSERT INTO
	common_mst(
		common_id,
		common_group,
		common_name,
		common_value1,
		common_value2
	)
VALUES
	(
		'com0002',
		'secret_question',
		'秘密の質問',
		'好きなアーティストは？',
		'好きなアーティストは？'
	);

INSERT INTO
	common_mst(
		common_id,
		common_group,
		common_name,
		common_value1,
		common_value2
	)
VALUES
	(
		'com0003',
		'secret_question',
		'秘密の質問',
		'昔、飼っていたペットの名前は？',
		'昔、飼っていたペットの名前は？'
	);
