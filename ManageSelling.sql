USE [master]
GO
/****** Object:  Database [Assgin_PRJ301]    Script Date: 4/18/2024 10:29:32 AM ******/
CREATE DATABASE [Assgin_PRJ301]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Assgin_PRJ301', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Assgin_PRJ301.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Assgin_PRJ301_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Assgin_PRJ301_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Assgin_PRJ301] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Assgin_PRJ301].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Assgin_PRJ301] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET ARITHABORT OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Assgin_PRJ301] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Assgin_PRJ301] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Assgin_PRJ301] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Assgin_PRJ301] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Assgin_PRJ301] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Assgin_PRJ301] SET  MULTI_USER 
GO
ALTER DATABASE [Assgin_PRJ301] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Assgin_PRJ301] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Assgin_PRJ301] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Assgin_PRJ301] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Assgin_PRJ301] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Assgin_PRJ301] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Assgin_PRJ301] SET QUERY_STORE = OFF
GO
USE [Assgin_PRJ301]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](20) NULL,
	[Descr] [nvarchar](1000) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[Customer_id] [varchar](10) NOT NULL,
	[FirstName] [varchar](50) NOT NULL,
	[LastName] [varchar](50) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[PhoneNumber] [varchar](20) NOT NULL,
	[Address] [varchar](200) NOT NULL,
	[DateOfBirth] [date] NULL,
	[Gender] [varchar](10) NULL,
	[Membership_id] [int] NULL,
	[Network] [varchar](100) NULL,
 CONSTRAINT [PK_Customerr] PRIMARY KEY CLUSTERED 
(
	[Customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MemberLevel]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MemberLevel](
	[Membership_id] [int] NOT NULL,
	[Membership_name] [varchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Membership_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[Order_id] [int] IDENTITY(1,1) NOT NULL,
	[Customer_id] [varchar](10) NULL,
	[Orderdate] [date] NULL,
	[Shipdate] [date] NULL,
	[Address] [varchar](100) NULL,
	[Shipcity] [varchar](40) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[Order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order detail]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Order_id] [int] NOT NULL,
	[Product_id] [varchar](20) NOT NULL,
	[Quantity] [int] NULL,
	[Price] [float] NULL,
	[Discount] [float] NULL,
	[User_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[Product_id] [varchar](20) NOT NULL,
	[Product_name] [nvarchar](255) NOT NULL,
	[Quantity] [int] NULL,
	[Unit] [nvarchar](10) NOT NULL,
	[Status] [varchar](50) NOT NULL,
	[Supplier_id] [varchar](40) NOT NULL,
	[Describe] [nvarchar](1000) NULL,
	[photo] [varchar](500) NULL,
	[Price] [float] NULL,
	[Created_at] [date] NULL,
	[Updated_at] [date] NULL,
	[CategoryID] [int] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[Product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[Supplier_id] [varchar](40) NOT NULL,
	[Supplier_name] [varchar](40) NULL,
	[Address] [nvarchar](30) NULL,
	[Phone] [varchar](10) NULL,
	[City] [nvarchar](20) NULL,
 CONSTRAINT [PK_Supplier] PRIMARY KEY CLUSTERED 
(
	[Supplier_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 4/18/2024 10:29:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[User_id] [int] IDENTITY(1,1) NOT NULL,
	[Displayname] [varchar](100) NULL,
	[FullName] [nvarchar](100) NULL,
	[Username] [varchar](50) NULL,
	[Password] [varchar](100) NULL,
	[Status] [bit] NOT NULL,
	[Address] [varchar](100) NULL,
	[Email] [varchar](100) NULL,
	[Phone] [varchar](10) NULL,
	[Role] [varchar](20) NULL,
	[Admin_userid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[User_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Product] ADD  DEFAULT (getdate()) FOR [Created_at]
GO
ALTER TABLE [dbo].[Product] ADD  DEFAULT (getdate()) FOR [Updated_at]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ((0)) FOR [Status]
GO
ALTER TABLE [dbo].[Customers]  WITH CHECK ADD  CONSTRAINT [foreign_key_memberlevel_cus] FOREIGN KEY([Membership_id])
REFERENCES [dbo].[MemberLevel] ([Membership_id])
GO
ALTER TABLE [dbo].[Customers] CHECK CONSTRAINT [foreign_key_memberlevel_cus]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [foreign_key_Order_customer] FOREIGN KEY([Customer_id])
REFERENCES [dbo].[Customers] ([Customer_id])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [foreign_key_Order_customer]
GO
ALTER TABLE [dbo].[Order detail]  WITH CHECK ADD  CONSTRAINT [foreign_key_ord_ord] FOREIGN KEY([Order_id])
REFERENCES [dbo].[Order] ([Order_id])
GO
ALTER TABLE [dbo].[Order detail] CHECK CONSTRAINT [foreign_key_ord_ord]
GO
ALTER TABLE [dbo].[Order detail]  WITH CHECK ADD  CONSTRAINT [foreign_key_pro_ord] FOREIGN KEY([Product_id])
REFERENCES [dbo].[Product] ([Product_id])
GO
ALTER TABLE [dbo].[Order detail] CHECK CONSTRAINT [foreign_key_pro_ord]
GO
ALTER TABLE [dbo].[Order detail]  WITH CHECK ADD  CONSTRAINT [foreign_key_User_order] FOREIGN KEY([User_id])
REFERENCES [dbo].[Users] ([User_id])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Order detail] CHECK CONSTRAINT [foreign_key_User_order]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [foreign_key_Category_prd] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([CategoryID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [foreign_key_Category_prd]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [foreign_key_pro_sup] FOREIGN KEY([Supplier_id])
REFERENCES [dbo].[Supplier] ([Supplier_id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [foreign_key_pro_sup]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [foreign_key_user_user] FOREIGN KEY([Admin_userid])
REFERENCES [dbo].[Users] ([User_id])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [foreign_key_user_user]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [chk_status] CHECK  (([Status]='out of stock' OR [Status]='stocking'))
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [chk_status]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [CK_Role] CHECK  (([Role]='staff' OR [Role]='admin'))
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [CK_Role]
GO
USE [master]
GO
ALTER DATABASE [Assgin_PRJ301] SET  READ_WRITE 
GO
