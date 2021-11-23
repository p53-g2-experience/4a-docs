from rest_framework import status, views
from rest_framework.response import Response
from dictionaryApp.models.word import Word
from dictionaryApp.DictionaryUtils import Functions_Global
from rest_framework.permissions import IsAuthenticated
from dictionaryApp.serializers.wordSerializer import WordSerializer


class WordCreateView(views.APIView):
    permission_classes = (IsAuthenticated,)
    def post(self, request, *args, **kwargs):
        try:
            if  Functions_Global.is_Authenticated(request):
                serializer = WordSerializer(data=request.data)
                serializer.is_valid(raise_exception=True)
                wordInstance = serializer.save()
                word = Word.objects.filter(id = wordInstance.id).first()
                wordSerializer = WordSerializer(word)
                return Response(wordSerializer.data, status=status.HTTP_201_CREATED)

        except Exception as ex:
            return Response(str(ex), status = status.HTTP_502_BAD_GATEWAY)