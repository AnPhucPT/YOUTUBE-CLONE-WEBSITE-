SELECT 
	v.ID, v.Title, v.Href, SUM(CAST(h.isLike AS INT)) AS TotalLike
FROM 
	Video v LEFT JOIN UserHistory h ON v.ID = h.VideoID
WHERE
	v.isActive = 1
GROUP BY 
	v.ID, v.Title, v.Href 
ORDER BY
	SUM(CAST(h.isLike AS INT)) DESC