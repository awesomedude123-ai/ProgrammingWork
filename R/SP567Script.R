##SP 5
install.packages("foreign")
library(foreign)
sp5.data <- read.delim("lab 5 sra 365 wc-1.dat",header=TRUE)

sp5.rm1 <- lm(fin_loss ~ dys_detect, data=sp5.data)
summary(sp5.rm1)

predict(sp5.rm1,data.frame(dys_detect=365),interval="confidence",level=0.85) ##Range of Means

predict(sp5.rm1,data.frame(dys_detect=365),interval="prediction",level=0.85) ##Range of Potential Values/Potental Range of Values


##SP 6
install.packages("foreign")
library(foreign)
sp6.data <- read.csv("lab 6 sra 365 wc-1.csv",header=TRUE)

install.packages("car")
library(car)
sp6.rm1 <- lm(cost_controls ~ per_sensitive, data=sp6.data)
dwt(sp6.rm1) ## tests for independence of observations


plot(sp6.rm1,which=1) ##tests for homogeneity of variance

plot(sp6.rm1,which=2) ##tests for normality

sp6.data$res <- resid(sp6.rm1) ##create residual values

shapiro.test(sp6.data$res) ##Shapiro-Wilk Normality Test

sp6.data$std.r = rstandard(sp6.rm1) ##Standardize residuals for outliers
View(sp6.data)


#SP 7
install.packages("leaps")
library(leaps)

install.packages("car")
library(car)

install.packages("foreign")
library(foreign)

sp7.data <- read.delim("lab 7 sra 365 wc.dat",header=TRUE)

View(sp7.data)

bestsubsets = regsubsets(fin_loss ~ num_people + num_records 
                         + per_sensitive + dys_impact + dys_detect+cost_controls,data=sp7.data,nbest=1)

subsets(bestsubsets,statistic="adjr2")

Model1 <- lm(fin_loss ~ num_records , data = sp7.data)
summary(Model1)

Model2 <- lm(fin_loss ~ num_records +dys_detect, data = sp7.data)
summary(Model2)

Model3 <- lm(fin_loss ~ num_records +dys_detect + per_sensitive, data = sp7.data)
summary(Model3)

Model4 <- lm(fin_loss ~ num_records +dys_detect + per_sensitive + cost_controls, data = sp7.data)
summary(Model4)

Model5 <- lm(fin_loss ~ num_records +dys_detect + per_sensitive + cost_controls+dys_impact, data = sp7.data)
summary(Model5)

Model6 <- lm(fin_loss ~ num_records +dys_detect + per_sensitive + cost_controls+dys_impact+num_people, data = sp7.data)
summary(Model6)

vif(Model6)

1/vif(Model6)

cor(sp7.data[, c("num_records", "dys_detect", "per_sensitive","cost_controls","dys_impact","num_people")])