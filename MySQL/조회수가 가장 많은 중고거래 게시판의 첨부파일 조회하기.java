
        SELECT concat('/home/grep/src/', b.BOARD_ID, '/', b.FILE_ID, b.FILE_NAME, b.FILE_EXT) as FILE_PATH
        FROM USED_GOODS_BOARD as a
        JOIN USED_GOODS_FILE as b
        ON a.BOARD_ID = b.BOARD_ID
        WHERE VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
        ORDER BY b.FILE_ID desc;
