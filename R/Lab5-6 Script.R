regression1 = lm(fin_loss ~ per_sensitive, data = lab5)
summary(regression1)

regression2 = lm(cost_controls ~ per_sensitive, data = lab5)

regression3 = lm(fin_loss ~ num_records, data = lab5)

regression4 = lm(cost_controls ~ num_records, data = lab5)

predict(regression4,data.frame(num_records=10),interval="prediction",level=.70)

predict(regression4,data.frame(num_records=10),interval="confidence",level=.70)

cyber_attacks <- read.csv("cyber-attack-v3.csv",header=TRUE)
cyber = lm(num_attack ~ cyber_literate_users, cyber_attacks)

install.packages("car")
library(car)
dwt(cyber)


cyber_attacks$resid = resid(cyber)
shapiro.test(cyber_attacks$resid)

#Independce of Observations
install.packages("car")
library(car)
lab6.data <- read.csv("lab 6 sra 365 wc-1.csv",header=TRUE)
lab6.reg = lm(dys_detect ~ per_sensitive,lab6.data)
dwt(lab6.reg)


##Variance of Homogeneity
plot(lab6.reg,which=1)

##Normality
plot(lab6.reg,which=2)

lab6.data$res = resid(lab6.reg)
shapiro.test(lab6.data$res)

#Outliers
lab6.data$str.res <- rstandard(lab6.reg)
View(lab6.data)


