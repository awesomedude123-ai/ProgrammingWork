install.packages("foreign")
library(foreign)

sri_the_god <- read.csv("lab 8 sra 365 wc.csv",header=TRUE)

sri_the_god$data_type <- as.factor(sri_the_god$data_type)

contrasts(sri_the_god$data_type) <- contr.treatment(6,base=3)

sri_the_king <- lm(num_people ~ data_type, data=sri_the_god)
summary(sri_the_king)

round(tapply(sri_the_god$num_people, sri_the_god$data_type, mean, na.rm = TRUE), 3)