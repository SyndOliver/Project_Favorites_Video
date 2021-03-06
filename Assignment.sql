USE [Ass]
GO
/****** Object:  Table [dbo].[Favorites]    Script Date: 3/7/2021 7:37:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Favorites](
	[FavoriteId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NULL,
	[VideoId] [varchar](50) NULL,
	[LikeDate] [date] NULL,
 CONSTRAINT [PK_Favorites] PRIMARY KEY CLUSTERED 
(
	[FavoriteId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Shares]    Script Date: 3/7/2021 7:37:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Shares](
	[ShareId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NULL,
	[VideoId] [varchar](50) NULL,
	[Emails] [nvarchar](250) NULL,
	[ShareDate] [date] NULL,
 CONSTRAINT [PK_Shares] PRIMARY KEY CLUSTERED 
(
	[ShareId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 3/7/2021 7:37:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[Username] [varchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NULL,
	[Admin] [bit] NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Videos]    Script Date: 3/7/2021 7:37:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Videos](
	[VideoId] [varchar](50) NOT NULL,
	[Title] [nvarchar](100) NOT NULL,
	[Poster] [nvarchar](100) NOT NULL,
	[Views] [int] NOT NULL,
	[Description] [nvarchar](1500) NULL,
	[Active] [bit] NOT NULL,
 CONSTRAINT [PK_Videos] PRIMARY KEY CLUSTERED 
(
	[VideoId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Favorites] ON 

INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikeDate]) VALUES (67, N'ps13568', N'vd2', CAST(N'2021-03-07' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikeDate]) VALUES (70, N'ps13568', N'vd1', CAST(N'2021-03-07' AS Date))
INSERT [dbo].[Favorites] ([FavoriteId], [Username], [VideoId], [LikeDate]) VALUES (75, N'sunsynd', N'vd1', CAST(N'2021-03-07' AS Date))
SET IDENTITY_INSERT [dbo].[Favorites] OFF
SET IDENTITY_INSERT [dbo].[Shares] ON 

INSERT [dbo].[Shares] ([ShareId], [Username], [VideoId], [Emails], [ShareDate]) VALUES (9, N'minhphuc', N'vd2', N'phuctmps13568@fpt.edu.vn', CAST(N'2021-02-27' AS Date))
INSERT [dbo].[Shares] ([ShareId], [Username], [VideoId], [Emails], [ShareDate]) VALUES (10, N'minhphuc', N'vd1', N'phuctmps13568@fpt.edu.vn', CAST(N'2021-03-01' AS Date))
INSERT [dbo].[Shares] ([ShareId], [Username], [VideoId], [Emails], [ShareDate]) VALUES (11, N'minhphucc', N'vd2', N'0hades001@gmail.com', CAST(N'2021-03-04' AS Date))
INSERT [dbo].[Shares] ([ShareId], [Username], [VideoId], [Emails], [ShareDate]) VALUES (14, N'minhphucc', N'vd9', N'0hades001@gmail.com', CAST(N'2021-03-07' AS Date))
INSERT [dbo].[Shares] ([ShareId], [Username], [VideoId], [Emails], [ShareDate]) VALUES (15, N'sunsynd', N'vd3', N'phuctmps13568@fpt.edu.vn', CAST(N'2021-03-07' AS Date))
SET IDENTITY_INSERT [dbo].[Shares] OFF
INSERT [dbo].[Users] ([Username], [Fullname], [Email], [Admin], [Password]) VALUES (N'minhphuc', N'Tran Minh Phucc', N'0hades001@gmail.com', 1, N'123456')
INSERT [dbo].[Users] ([Username], [Fullname], [Email], [Admin], [Password]) VALUES (N'minhphucc', N'Tran Minh Phuc123569788', N'phuctmps13568@fpt.edu.vn', 0, N'123456')
INSERT [dbo].[Users] ([Username], [Fullname], [Email], [Admin], [Password]) VALUES (N'ps13568', N'Tran Minh Phuc', N'phuctmps13568@fpt.edu.vn', 0, N'123456')
INSERT [dbo].[Users] ([Username], [Fullname], [Email], [Admin], [Password]) VALUES (N'sunsynd', N'Tran Minh Phuc', N'phuctmps13568@fpt.edu.vn', 0, N'123456')
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd1', N'TOM & JERRY: QU&#7852;Y TUNG NEW YORK', N'images/vd1.jpg', 1036, N'Sau nhi&#7873;u n&#259;m chành ch&#7885;e, nay c&#7863;p k&#7923; phùng &#273;&#7883;ch th&#7911; n&#7893;i ti&#7871;ng nh&#7845;t th&#7871; gi&#7899;i Tom và Jerry &#273;ã làm hòa, kh&#259;n gói r&#7901;i kh&#7887;i mái nhà chung, và b&#7855;t &#273;&#7847;u hành trình c&#7911;a riêng mình. Chu&#7897;t Jerry nay trú ng&#7909; t&#7841;i m&#7897;t khách s&#7841;n sang tr&#7885;ng, n&#417;i chu&#7849;n b&#7883; t&#7893; ch&#7913;c m&#7897;t &#273;ám c&#432;&#7899;i Th&#7871; k&#7927;. Cô nhân viên m&#7899;i Kayla &#273;&#432;&#7907;c giao cho nhi&#7879;m v&#7909; &#273;u&#7893;i Jerry &#273;i nên mang v&#7873; m&#7897;t chàng mèo mình &#273;&#7847;y kinh nghi&#7879;m &#273;&#7889;i phó v&#7899;i chu&#7897;t, không ai khác chính là Tom. Và th&#7871; là cu&#7897;c chi&#7871;n mèo - chu&#7897;t l&#7841;i n&#7893; ra, kéo theo lo&#7841;t r&#7855;c r&#7889;i cho khách s&#7841;n, và bi&#7871;t bao tình hu&#7889;ng d&#7903; khóc d&#7903; c&#432;&#7901;i.', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd2', N'TH&#7906; S&#258;N QUÁI V&#7852;T', N'images/vd2.jpg', 1949, N'Monster Hunter &#273;&#432;&#7907;c chuy&#7875;n th&#7875; t&#7915; series game n&#7893;i ti&#7871;ng cùng tên c&#7911;a Capcom. Trong phim, &#273;&#7897;i tr&#432;&#7903;ng Artemis c&#7911;a n&#7919; di&#7877;n viên Milla Jovovich và &#273;&#7891;ng &#273;&#7897;i &#273;ã vô tình b&#432;&#7899;c qua m&#7897;t cánh c&#7917;a bí &#7849;n d&#7851;n t&#7899;i th&#7871; gi&#7899;i khác. T&#7841;i &#273;ây, h&#7885; ph&#7843;i chi&#7871;n &#273;&#7845;u v&#7899;i nhi&#7873;u loài quái v&#7853;t kh&#7893;ng l&#7891; trong hành trình tr&#7903; v&#7873; th&#7871; gi&#7899;i. &#272;&#7891;ng hành v&#7899;i h&#7885; trong tr&#7853;n chi&#7871;n là nhân v&#7853;t Th&#7907; s&#259;n c&#7911;a nam di&#7877;n viên Tony Jaa. Monster Hunter h&#7913;a h&#7865;n s&#7869; là bom t&#7845;n hành &#273;&#7897;ng v&#7899;i nh&#7919;ng màn s&#259;n quái v&#7853;t kh&#7893;ng l&#7891; hoành tráng nh&#7845;t n&#259;m 2020.', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd3', N'PHÒNG CHAT QU&#7926; ÁM', N'images/vd3.jpg', 15033, N'Host mang &#273;&#7871;n tr&#7843;i nghi&#7879;m kinh d&#7883; m&#7899;i l&#7841; cho ng&#432;&#7901;i xem, n&#7897;i dung phim &#273;&#417;n gi&#7843;n &#273;&#7871;n n&#7895;i &#273;ôi lúc b&#7841;n s&#7869; nh&#7847;m t&#432;&#7903;ng r&#7841;p chi&#7871;u l&#7897;n phim, ch&#7911; &#273;&#7873; nói v&#7873; m&#7897;t bu&#7893;i h&#7885;p qua &#7913;ng d&#7909;ng Zoom nh&#432;ng mang l&#7841;i s&#7913;c hút vô cùng l&#7899;n.

B&#7897; phim l&#7845;y b&#7889;i c&#7843;nh di&#7877;n ra khi &#273;&#7841;i d&#7883;ch Covid-19 &#273;ang hoành hành &#7903; kh&#7855;p m&#7885;i n&#417;i và m&#7885;i ng&#432;&#7901;i v&#7851;n &#273;ang ph&#7843;i th&#7921;c hi&#7879;n các bi&#7879;n pháp cách ly xã h&#7897;i &#273;&#7875; phòng ch&#7889;ng s&#7921; lây lan. M&#7897;t nhóm b&#7841;n tr&#7867; 6 ng&#432;&#7901;i &#273;ã ngh&#297; ra m&#7897;t trò ch&#417;i g&#7885;i h&#7891;n online và kêu g&#7885;i m&#7885;i ng&#432;&#7901;i vào phòng h&#7885;p Zoom &#273;&#7875; th&#7921;c hi&#7879;n nghi l&#7877; này.

Câu chuy&#7879;n b&#7855;t &#273;&#7847;u r&#7845;t &#273;&#7895;i bình th&#432;&#7901;ng, các thành viên trong phòng chat nói chuy&#7879;n v&#7899;i nhau nh&#432; bao phòng h&#7885;p nhóm khác r&#7845;t vui v&#7867;. Tuy v&#7853;y khi mà ng&#432;&#7901;i có kinh nghi&#7879;m nh&#7845;t b&#7883; m&#7845;t k&#7871;t n&#7889;i thì m&#7885;i chuy&#7879;n l&#7841;i tr&#7903; nên vô cùng &#273;áng s&#7907;.', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd4', N'GIA &#272;ÌNH CHÂN TO PHIÊU L&#431;U KÝ', N'images/vd4.jpg', 720, N'Gia &#272;ình Chân To Phiêu L&#432;u Ký ti&#7871;p n&#7889;i ph&#7847;n phim B&#7889; T&#7899; Là Chân To (2017) t&#7915;ng theo chân c&#7853;u bé Adam tìm ki&#7871;m ng&#432;&#7901;i cha m&#7845;t tích &#273;ã lâu c&#7911;a mình và phát hi&#7879;n ra ông là m&#7897;t ng&#432;&#7901;i r&#7915;ng Chân To trong truy&#7873;n thuy&#7871;t. Ph&#7847;n phim này s&#7869; &#273;&#432;a khán gi&#7843; &#273;&#7871;n v&#7899;i cu&#7897;c phiêu l&#432;u &#273;&#7847;y thú v&#7883; sau khi gia &#273;ình &#273;oàn t&#7909;, Adam và b&#7889; tr&#7903; thành nh&#7919;ng g&#432;&#417;ng m&#7863;t &#273;&#432;&#7907;c truy&#7873;n thông s&#259;n &#273;ón. Và v&#7899;i mong mu&#7889;n truy&#7873;n &#273;i thông &#273;i&#7879;p ý ngh&#297;a v&#7873; môi tr&#432;&#7901;ng, c&#7843; nhà quy&#7871;t &#273;&#7883;nh kh&#7903;i hành &#273;&#7871;n Alaska. Trong lúc &#273;ang d&#7889;c s&#7913;c &#273;&#7875; mang l&#7841;i nh&#7919;ng &#273;i&#7873;u tuy&#7879;t v&#7901;i cho vùng &#273;&#7845;t này, h&#7885; &#273;ã phát hi&#7879;n ra m&#7897;t âm m&#432;u &#273;en t&#7889;i, tàn phá môi tr&#432;&#7901;ng. S&#7903; h&#7919;u kh&#7843; n&#259;ng &#273;&#7863;c bi&#7879;t, li&#7879;u gia &#273;ình Chân To có ng&#259;n ch&#7863;n &#273;&#432;&#7907;c âm m&#432;u &#273;&#7897;c ác này và b&#7843;o v&#7879; th&#7871; gi&#7899;i?', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd5', N'&#272;&#7914;NG G&#7884;I ANH LÀ B&#7888;!', N'images/vd5.jpg', 312, N'&#272;&#7915;ng G&#7885;i Anh Là B&#7889;! xoay quanh m&#7889;i quan h&#7879; b&#7845;t hòa gi&#7919;a Got  m&#7897;t tay &#273;ua và ng&#432;&#7901;i b&#7889; Prem. M&#7897;t tai n&#7841;n xe h&#417;i &#273;&#432;a anh tr&#7903; v&#7873; kho&#7843;ng th&#7901;i gian b&#7889; anh v&#7851;n còn tr&#7867; và vô tình tr&#7903; thành b&#7841;n chí c&#7889;t c&#7911;a b&#7889;. Thông qua chuy&#7871;n xuyên không kì di&#7879;u này, anh có c&#417; h&#7897;i g&#7863;p l&#7841;i &#273;&#432;&#7907;c m&#7865; và hi&#7875;u h&#417;n v&#7873; câu chuy&#7879;n &#273;&#7857;ng sau tính cách c&#7897;c c&#7857;n c&#7911;a b&#7889;.', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd6', N'THANH G&#431;&#416;M DI&#7878;T QU&#7926; : CHUY&#7870;N TÀU VÔ T&#7852;N', N'images/vd6.jpg', 2556, N'Thanh G&#432;&#417;m Di&#7879;t Qu&#7927; : Chuy&#7871;n Tàu Vô T&#7853;n - Kimetsu no Yaiba : Mugen Ressha-hen là b&#7897; phim &#273;i&#7879;n &#7843;nh anime &#273;&#432;&#7907;c công chi&#7871;u vào n&#259;m 2020 d&#7921;a trên Manga Thanh G&#432;&#417;m Di&#7879;t Qu&#7927; c&#7911;a tác gi&#7843; Got&#333;ge Koyoharu. &#272;ây là ph&#7847;n phim n&#7889;i ti&#7871;p lo&#7841;t phim anime &#273;&#432;&#7907;c phát hành n&#259;m 2019, do &#273;&#7841;o di&#7877;n Haruo Sotozaki ch&#7883;u trách nhi&#7879;m ch&#7881; &#273;&#7841;o, nhà s&#7843;n xu&#7845;t c&#7911;a b&#7897; phim là Ufotable.

Trên &#273;&#432;&#7901;ng &#273;i&#7873;u tra s&#7921; m&#7845;t tích c&#7911;a các Ki&#7871;m S&#297; thu&#7897;c &#272;&#7897;i Di&#7879;t Qu&#7927;, Tanjiro và các &#273;&#7891;ng &#273;&#7897;i cùng Viêm Tr&#7909; Rengoku r&#417;i vào Huy&#7871;t Qu&#7927; Thu&#7853;t &#7843;o m&#7897;ng c&#7911;a Qu&#7927; H&#7841; Huy&#7873;n Enmu. C&#7843; b&#7885;n ph&#7843;i hi&#7879;p l&#7921;c &#273;&#7875; b&#7843;o toàn tính m&#7841;ng cho 200 hành khách trên chuy&#7871;n tàu Vô T&#7853;n.', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd8', N'N&#7918; TH&#7846;N CHI&#7870;N BINH 2: N&#7918; TH&#7846;N CHI&#7870;N BINH 1984', N'images/vd8.jpg', 109437, N'Wonder Woman 1984 s&#7869; l&#7845;y b&#7889;i c&#7843;nh n&#259;m 1984, khi M&#7929; và Liên Xô &#273;&#7889;i &#273;&#7847;u trong th&#7901;i k&#7923; Chi&#7871;n tranh L&#7841;nh. &#272;&#7863;c bi&#7879;t c&#361;ng hé l&#7897; s&#7921; tr&#7903; l&#7841;i bí &#7849;n c&#7911;a Steve Trevor  ng&#432;&#7901;i &#273;ã hy sinh anh d&#361;ng nh&#7857;m ng&#259;n ch&#7863;n k&#7871; ho&#7841;ch phát tán ch&#7845;t &#273;&#7897;c c&#7911;a &#272;&#7913;c qu&#7889;c xã.
', 1)
INSERT [dbo].[Videos] ([VideoId], [Title], [Poster], [Views], [Description], [Active]) VALUES (N'vd9', N'TANET2', N'images/vd9.jpg', 3009, N'Tanet2', 1)
ALTER TABLE [dbo].[Favorites]  WITH CHECK ADD  CONSTRAINT [FK_Favorites_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
GO
ALTER TABLE [dbo].[Favorites] CHECK CONSTRAINT [FK_Favorites_Users]
GO
ALTER TABLE [dbo].[Favorites]  WITH CHECK ADD  CONSTRAINT [FK_Favorites_Videos] FOREIGN KEY([VideoId])
REFERENCES [dbo].[Videos] ([VideoId])
GO
ALTER TABLE [dbo].[Favorites] CHECK CONSTRAINT [FK_Favorites_Videos]
GO
ALTER TABLE [dbo].[Shares]  WITH CHECK ADD  CONSTRAINT [FK_Shares_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Users] ([Username])
GO
ALTER TABLE [dbo].[Shares] CHECK CONSTRAINT [FK_Shares_Users]
GO
ALTER TABLE [dbo].[Shares]  WITH CHECK ADD  CONSTRAINT [FK_Shares_Videos] FOREIGN KEY([VideoId])
REFERENCES [dbo].[Videos] ([VideoId])
GO
ALTER TABLE [dbo].[Shares] CHECK CONSTRAINT [FK_Shares_Videos]
GO
