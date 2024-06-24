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
