-- Oracle solution for https://leetcode.com/problems/monthly-transactions-i/
SELECT
    TO_CHAR(t.trans_date, 'YYYY-MM') AS month,
    t.country,
    COUNT(*) AS trans_count,
    SUM(CASE WHEN t.state = 'approved' THEN 1 ELSE 0 END) AS approved_count,
    SUM(t.amount) AS trans_total_amount,
    SUM(CASE WHEN t.state = 'approved' THEN t.amount ELSE 0 END) AS approved_total_amount
FROM Transactions t
GROUP BY t.country, TO_CHAR(t.trans_date, 'YYYY-MM')