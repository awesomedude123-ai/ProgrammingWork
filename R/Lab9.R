install.packages("foreign")
install.packages("car")
library(foreign)
library(car)

sp9.data <- read.delim("lab 9 sra 365 wc.dat",header=TRUE)
sp9.data$dys_detect_v2 = as.factor(sp9.data$dys_detect_v2)

sp9.reg = glm(dys_detect_v2 ~ per_sensitive,data = sp9.data, family=binomial)
summary(sp9.reg)

exp(sp9.reg$coefficients)

sp9.data$dys_detect_v2 = relevel(sp9.data$dys_detect_v2, "Slow")

sp9.reg = glm(dys_detect_v2 ~ per_sensitive,data = sp9.data, family=binomial)

exp(sp9.reg$coefficients)


install.packages("foreign")
library(foreign)

lab10.data <- read.csv("lab 10 sra 365 wc-1.csv",header=TRUE)

#Step 2: Install 'gmodels' packages and then load it in R.
install.packages("gmodels")
library(gmodels)

#Step 3: Use CrossTable() function to run a chi-square test in R
CrossTable(lab10.data$num_people_v2,lab10.data$cost_controls_v2, fisher = TRUE, chisq = TRUE, expected=TRUE, sresid = TRUE, format = "SPSS")

CrossTable(lab10.data$per_sensitive_v2,lab10.data$cost_controls_v2, fisher = TRUE, chisq = TRUE, expected=TRUE, sresid = TRUE, format = "SPSS")

CrossTable(lab10.data$dys_detect_v2,lab10.data$cost_controls_v2, fisher = TRUE, chisq = TRUE, expected=TRUE, sresid = TRUE, format = "SPSS")

install.packages("car")
library(car)

lab10.reg = lm(cost_controls_v2~num_people_v2,data=lab10.data)