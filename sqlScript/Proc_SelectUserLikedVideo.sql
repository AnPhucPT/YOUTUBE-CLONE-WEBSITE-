GO
CREATE PROC SP_SelectUserLikedVideoByVideoHref(@VideoHref nvarchar(50))
AS BEGIN 
	SELECT u.*
	FROM Video v LEFT JOIN UserHistory h on v.ID = h.VideoID LEFT JOIN [User] u on u.ID = h.UserID
	WHERE v.Href = @VideoHref and u.isActive = 1 AND v.isActive = 1 AND h.isLike = 1
END

SELECT u.*
	FROM Video v LEFT JOIN UserHistory h on v.ID = h.VideoID LEFT JOIN [User] u on u.ID = h.UserID
	WHERE v.Href = '4VmesVmTURQ' and u.isActive = 1 AND v.isActive = 1 AND h.isLike = 1












