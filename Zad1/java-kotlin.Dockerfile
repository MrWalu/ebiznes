FROM ubuntu:24.04

# Zainstaluj wymagane pakiety
RUN apt-get update && apt-get install -y \
    curl zip unzip gnupg2 ca-certificates \
    openjdk-8-jdk \
    && apt-get clean

# Ustaw JAVA_HOME i PATH
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

# Zainstaluj SDKMAN
ENV SDKMAN_DIR=/root/.sdkman
RUN curl -s "https://get.sdkman.io" | bash && \
    bash -c "source $SDKMAN_DIR/bin/sdkman-init.sh && sdk install kotlin"

# Dodaj Kotlin do PATH
ENV PATH="${SDKMAN_DIR}/candidates/kotlin/current/bin:$PATH"

# Ustaw katalog roboczy
WORKDIR /app

# Domyślnie uruchamiaj bash
CMD ["/bin/bash"]
